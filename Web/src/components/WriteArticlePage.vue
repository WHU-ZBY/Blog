<!-- writeArticlePage -->
<template>
  <div class="pageWrap">
    <topbar></topbar>
    <a-row class="mainPart">
      <a-col :span="6"></a-col>
      <a-col :span="12">
        <div class="writeWrap">
          <div class="notification">标题:</div>
          <a-input v-model="title" class="title" size="large" placeholder="title" />
          <div class="notification">简介:</div>
          <a-textarea v-model="intro" class="intro" placeholder="intro" :rows="4" />
          <div class="notification">正文:</div>
          <ckeditor4 v-model="content"></ckeditor4>
          <a-button type="primary" @click="doWrite" class="submitButton">完成</a-button>
        </div>
      </a-col>
      <a-col :span="6"></a-col>
    </a-row>
    <bottomBar></bottomBar>
  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import topbar from "../components/wrap/topBar";
import bottomBar from "../components/wrap/bottomBar";
import ckeditor4 from "../components/wrap/CKEeditor";
export default {
  //import引入的组件需要注入到对象中才能使用
  components: {
    topbar,
    bottomBar,
    ckeditor4
  },
  data() {
    //这里存放数据
    return {
      title: "",
      intro: "",
      content: ""
    };
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
    doWrite() {
      this.axios
        .post("http://106.15.182.82:8080/article/create", {
          category_id: "1",
          uid: this.$store.state.uid,
          title: this.title,
          intro: this.intro,
          content: this.content,
          picture_url: "test_url"
        })
        .then(response => {
        //  这里怎么判断是否发布成功？？
        })
        .catch(function(error) {
          console.log(error);
        });
      console.log("submit");
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
.pageWrap {
  height: 100%;
  width: 100%;
  position: fixed;
  overflow: auto;
  background: url("../assets/image/background/bg2.jpg") right no-repeat;
  background-size: 18%;
}
.writeWrap {
  margin-top: 10%;
}
.title {
  width: 50%;
}
.notification {
  margin-top: 5%;
  font-size: 18px;
  font: 700;
  margin-bottom: 1%;
}
.submitButton {
  margin-top: 5%;
  margin-left: 45%;
}
</style>