<!--SearchPage -->
<template>
  <div class="pageWrap">
    <topbar></topbar>
    <a-row>
      <a-col :span="6"></a-col>
      <a-col :span="12">
              <div class="searchWrap">
                  <a-input-search placeholder="SEARCH" @search="onSearch" class="searchButton" enterButton />
              </div>
              <div class="resultWrap"></div>
      </a-col>
      <a-col :span="6"></a-col>
    </a-row>
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
    topbar
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
  methods: {
      onSearch(){
          console.log("search");
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
.pageWrap{
  background: url("../assets/image/background/bg4.png") left top no-repeat;
  background-size: 100%;
  height: 100%;
  width: 100%;
  position: fixed;
}
.searchButton{
    width: 60%;
    margin-left: 20%;
    margin-top: 15%;
}
</style>