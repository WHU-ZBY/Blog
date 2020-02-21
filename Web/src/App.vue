<template>
  <div id="app">
    <router-view />
  </div>
</template>
<script>
export default {
  name: "App",
   mounted(){
           
        }
};

</script>
<style>
html {
  height: 100%;
}
body {
  height: 100%;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  padding: 1px;

  /* 设置了之后发现在子元素中设置margin不会改变背景图片 */
}
</style>
