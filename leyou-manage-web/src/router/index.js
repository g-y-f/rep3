import Vue from 'vue'
import Router from 'vue-router'//引入vue路由


Vue.use(Router)//安装插件

function route (path, file, name, children) {
  return {
    exact: true,
    path,
    name,
    children,
    component: () => import('../pages' + file)
  }
}

export default new Router({
  routes: [
    route("login",'/Login',"Login"),// /login路径，路由到登录组件
    {
      path:"/", // //配置默认的路径，默认显示登录页
      component: () => import('../pages/Login'),
      //redirect:"/index/dashboard",
      children:[ // 其它所有组件都是 Layout的子组件
        route("/index/dashboard","/Dashboard","Dashboard"),
        route("/item/category",'/item/Category',"Category"),
        route("/item/brand",'/item/Brand',"Brand"),
        route("/item/list",'/item/Goods',"Goods"),
        route("/item/specification",'/item/specification/Specification',"Specification"),
        route("/user/statistics",'/item/Statistics',"Statistics"),
        route("/trade/promotion",'/trade/Promotion',"Promotion")
      ]
    }
  ]
})
