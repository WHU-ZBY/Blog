<!-- article小的wrap，用在mainPage处 -->
<template>
  <div class="articlePartWrap">
    <br>
    <div class="articleHoverWrap" @click="toArticle">
    <div class="articleTitle">{{item.title}}</div>
    <div class="articleIntro">{{item.intro}}</div>
    <div class="articleDate">{{article_date}}</div>
    </div>
    <br />
    <hr class="hrClass">
  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
    name:"article-intro",
  //import引入的组件需要注入到对象中才能使用
  components: {},
  data() {
    //这里存放数据
    return {
        article_title:"article_title",
        article_introduce:"article_introduce",
        article_date:"article_date"
    };
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
      toArticle(){
          console.log("ok")
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
.hrClass{
    width: 40%;
    color: #95a5a6;
}
.articlePartWrap{
    font-size: 20px;
}
.articleHoverWrap{
     transition:all .3s;
}
.articleHoverWrap:hover{
   	transform:scale(1.1);
}
.articleDate{
    color: #95a5a6;
}
</style>