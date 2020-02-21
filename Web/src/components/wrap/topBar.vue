<!--  -->
<template>
  <div class="topBar">
    <a-menu v-model="current" mode="horizontal">
      <a-menu-item key="blog" @click="toBlog">
        <a-icon type="mail" />Blog
      </a-menu-item>
      <a-menu-item key="write" @click="toWrite">
        <a-icon type="book" />Write Article
      </a-menu-item>
      <a-sub-menu>
        <span slot="title" class="submenu-title-wrapper">
          <a-icon type="setting" />Setting
        </span>
        <a-menu-item-group title="Item 1">
          <a-menu-item key="setting:1">Option 1</a-menu-item>
          <a-menu-item key="setting:2">Option 2</a-menu-item>
        </a-menu-item-group>
        <a-menu-item-group title="Item 2">
          <a-menu-item key="setting:3">Option 3</a-menu-item>
          <a-menu-item key="setting:4">Option 4</a-menu-item>
        </a-menu-item-group>
      </a-sub-menu>
      <a-menu-item key="tools" @click="toTools">
        <a-icon type="appstore" />Tools
      </a-menu-item>
      <a-menu-item key="search" @click="toSearch">
        <a-icon type="search" />Search
      </a-menu-item>
      <a-menu-item key="person" @click="toPerson">
        <a-icon type="user" />Person
      </a-menu-item>
    </a-menu>
  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
  name: "topbar",
  //import引入的组件需要注入到对象中才能使用
  components: {},
  data() {
    //这里存放数据
    return {
      current: ["mail"]
    };
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
    toBlog(){
      this.$router.push({ name: "mainPage" });
      console.log("to Blog")
    },
    toWrite(){
      this.$router.push({ name: "writeArticlePage" });
      console.log("to Write")
    },
    toTools(){
      this.$router.push({ name: "toolsPage" });
      console.log("to tools")
    },
    toSearch(){
      this.$router.push({ name: "searchPage" });
      console.log("to search")
    },
    toPerson(){
      this.$router.push({ name: "personPage" });
      console.log("to person")
    }
  },
  //生命周期 - 创建完成（可以访问当前this实例）
  created() {},
  //生命周期 - 挂载完成（可以访问DOM元素）
  mounted() {},
  beforeCreate() {}, //生命周期 - 创建之前
  beforeMount() {}, //生命周期 - 挂载之前
  beforeUpdate() {}, //生命周期 - 更新之前
  updated() {}, //生命周期 - 更新之后
  beforeDestroy() {}, //生命周期 - 销毁之前
  destroyed() {}, //生命周期 - 销毁完成
  activated() {} //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style scoped>
.topBar {
  text-align: center;
  opacity: 1;
}
.ant-menu {
  color: white;
  font: bold;
  font-size: 20px;
  background-color: #f5cd79;
}
</style>