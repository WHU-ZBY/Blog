<!-- PersonPage-->
<template>
  <div class="pageWrap">
    <topbar></topbar>
    <div class="personWrap">
      <img src="../assets/image/background/bg2.jpg" class="avatar" alt />
      <div class="introWrap">
        <div class="introPart">
          <p>昵称:</p>
          <div class="nickname">nickname</div>
        </div>
        <div class="introPart">
          <p>账号:</p>
          <div class="uid">uid</div>
        </div>
        <div class="introPart">
          <p>邮箱:</p>
          <div class="email">email</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import topbar from "../components/wrap/topBar";
import bottomBar from "../components/wrap/bottomBar";
export default {
  //import引入的组件需要注入到对象中才能使用
  components: {
    topbar,
    bottomBar
  },
  data() {
    //这里存放数据
    return {};
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {},
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
.pageWrap {
  margin: 0;
  background: url("../assets/image/background/bg5.jpg") left top no-repeat;
  background-size: 100%;
  height: 100%;
  width: 100%;
  position: fixed;
  overflow: hidden;
}
.personWrap {
  text-align: center;
  margin-top: 5%;
  color: white;
  font-size: 20px;
}
.avatar {
  height: 120px;
  width: auto;
  border-radius: 50%;
}
.introPart {
  display: flex;
  flex-direction: row;
  margin-left: 46%;
  margin-top: 10px;
}
.nickname,
.uid,
.email {
  margin-left: 12px;
}
.introWrap{
    margin-top: 5%;
}
</style>