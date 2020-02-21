<!-- Toast -->
<template>
<div class='toastWrap' v-show="visible" >
    {{message}}
</div>

</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
//import引入的组件需要注入到对象中才能使用
name : "toast",
components: {},
data() {
//这里存放数据
return {
    message: '', // 消息文字
      duration: 1000, // 显示时长，毫秒
      closed: false, // 用来判断消息框是否关闭
      timer: null, // 计时器
      visible: false // 是否显示
};
},
//监听属性 类似于data概念
computed: {},
//监控data中的数据变化
watch: {
     closed (newVal) {
      if (newVal) {
        this.visible = false
        this.destroyElement()
      }
    }
},
//方法集合
methods: {
destroyElement () {
      this.$destroy()
      this.$el.parentNode.removeChild(this.$el)
    },
    startTimer () {
      this.timer = setTimeout(() => {
        if (!this.closed) {
          this.closed = true
          clearTimeout(this.timer)
        }
      }, this.duration)
    }
},
//生命周期 - 创建完成（可以访问当前this实例）
created() {

},
//生命周期 - 挂载完成（可以访问DOM元素）
mounted() {
 this.startTimer()
},
beforeCreate() {}, //生命周期 - 创建之前
beforeMount() {}, //生命周期 - 挂载之前
beforeUpdate() {}, //生命周期 - 更新之前
updated() {}, //生命周期 - 更新之后
beforeDestroy() {}, //生命周期 - 销毁之前
destroyed() {}, //生命周期 - 销毁完成
activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style scoped>
.toastWrap {
  position: fixed;
  bottom: 15vh;
  left: 28vw;
  min-width: 40vw;
  max-width: 100vw;
  font-size: 26px;
  text-align: center;
  padding: 10px 2vw;
  border-radius: 40px;
  background-color: rgba(0, 0, 0 , 0.6);
  color: rgb(223, 219, 219);
  letter-spacing: 3px;
}
</style>