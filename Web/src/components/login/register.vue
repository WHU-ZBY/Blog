<template>
  <div class="registerSonWrap">
    <a-input class="inputNickName" placeholder="此处输入昵称" v-model="nickname" />
    <a-input-password class="inputPassword1" placeholder="此处输入第一次密码" v-model="password" />
    <a-input-password class="inputPassword2" placeholder="此处输入第二次密码" v-model="repassword" />
    <a-input class="inputEmail" placeholder="此处输入邮箱" v-model="email" />
    <!-- <a-input class="inputCheakNum" placeholder="输入验证码" v-model="identifiedCode"> -->
    <a-button type="primary" class="registerButton" @click="register">注册</a-button>
  </div>
</template>
<script>
import jwtDecode from 'jwt-decode'
export default {
  name: "register",
  data() {
    return {
      nickname: "",
      password: "",
      repassword: "",
      email: "",
      identifiedCode: ""
    };
  },
  methods: {
    register() {
      console.log(this.nickname);
      this.axios
        .get("http://106.15.182.82:8080/register", {
          params: {
            nick_name: this.nickname,
            password: this.password,
            re_password: this.repassword,
            email: this.email
          }
        })
        .then(response => {
          var token = response.data;
          const decoded = jwtDecode(token);
          console.log(decoded.userId);
          this.$store.commit("$_setToken", token);
          this.$store.commit("$_setUid",decoded.userId);
          this.$toast("注册成功");
          this.$router.push({ name: "mainPage" });
        })
        .catch(function(error) {
          console.log(error);
          this.$toast("注册失败");
        });
    }
  }
};
</script>
<style  scoped>
.registerSonWrap {
  display: flex;
  flex-direction: column;
}
.inputNickName,
.inputPassword1,
.inputPassword2,
.inputEmail,
.registerButton {
  margin-top: 10px;
}
.inputNickName,
.inputPassword1,
.inputPassword2,
.inputEmail {
  width: 65%;
  margin-left: 20%;
}
.registerButton {
  width: 20%;
  margin-left: 40%;
}
</style>