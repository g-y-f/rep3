<template>
  <div>
    hello
  <v-data-table
    :headers="headers"
    :items="brands"
    :pagination.sync="pagination"
    :total-items="totalBrands"
    :loading="loading"
    class="elevation-1"
  >
    <template slot="items" slot-scope="props">
      <td class="text-xs-center">{{ props.item.id }}</td>
      <td class="text-xs-center">{{ props.item.name }}</td>
      <td class="text-xs-center">
        <img v-if="props.item.image" :src="props.item.image" width="130" height="40">
        <span v-else>无</span>
      </td>
      <td class="text-xs-center">{{ props.item.letter }}</td>
      </template>
      </v-data-table>
  </div>
</template>

<script>
    export default {
        name: "myBrand",
      data(){
        return{
          headers:[
            {text:"品牌id",value:id,align:"center" ,sortable:true},
            {text:"品牌名称",value:id,align:"name" ,sortable:false},
            {text:"品牌LOGO",value:id,align:"image" ,sortable:false},
            {text:"品牌首字母",value:id,align:"letter" ,sortable:true}
          ],
          brand:[]
        }
      },
      created(){

      }
    }
</script>

<style scoped>

</style>
