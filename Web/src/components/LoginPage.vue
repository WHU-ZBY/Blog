<template>
  <div class="loginPage">
    <div class="loginWrap">
      <div class="userLinkBar row">
        <router-link to="/login" class="userLink">Login</router-link>
        <router-link to="/register" class="userLink">Register</router-link>
      </div>
      <div class="inputWrap">
        <transition mode="out-in">
          <router-view />
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  data() {
    return {};
  },
  methods: {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.loginPage {
  background: url("../assets/image/background/bg1.jpg") left top no-repeat;
  background-size: 100%;
  height: 100%;
  width: 100%;
  position: fixed;
}
.loginWrap {
  margin-left: 20%;
}
a {
  text-decoration: none;
}

.inputWrap {
  margin-top: 20px;
}

.v-enter,
.v-leave-to {
  opacity: 0;
  transform: translateX(140px);
}

.v-enter-active,
.v-leave-active {
  transition: all 0.5s ease;
}
.userLinkBar {
  padding-top: 20px;
  margin-left: 25%;
}
.userLink {
  margin-left: 20px;
  font-size: 28px;
  color: #7f8c8d;
}

.router-link-exact-active {
  font-size: 28px;
  color: #3498db;
  font: 800;
  background-color: bisque;
  text-decoration-line: none;
}
.loginWrap {
  height: auto;
  width: 450px;
  display: block;
  padding-bottom: 20px;
  background-color: bisque;
  border-radius: 15px;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  transition: 0.1s ease-in-out;
  margin-top: 15%;
}
</style>
