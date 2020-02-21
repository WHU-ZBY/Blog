<template>
  <div class="loginSonWrap">
    <a-input class="inputAccount" placeholder="此处需要输入账号" v-model="account" />
    <a-input-password class="inputPassword" placeholder="此处需要输入密码" v-model="password" />
    <a-button type="primary" class="loginButton" @click="login">登录</a-button>
  </div>
</template>
<script>
export default {
  name: "login",
  data() {
    return {
      account: "",
      password: "",
      response: ""
    };
  },
  methods: {
    login() {
      this.axios
        .get("http://106.15.182.82:8080/login", {
          params: { uid: this.account, password: this.password }
        })
        .then(response => {
          var token = response.data;
          this.$store.commit("$_setToken", token);
          this.$store.commit("$_setUid",this.account);
          this.$toast("登陆成功");

          this.$router.push({ name: "mainPage" });
        })
        .catch(function(error) {
          console.log(error);
          this.$toast("验证失败");
        });
    }
  }
};
</script>
<style scoped>
.loginSonWrap {
  flex-flow: column;
}
.inputAccount {
  display: block;
}
.inputPassword {
  display: block;
}
.loginButton,
.inputAccount,
.inputPassword {
  margin-top: 20px;
}
.inputAccount,
.inputPassword {
  width: 65%;
  margin-left: 20%;
}
.loginButton {
  margin-left: 40%;
}
</style>