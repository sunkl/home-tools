<template>
  <div>
    <div class="search_div">
      <div style="margin-top: 15px;">
        <el-select v-model="selectType" clearable class="selectType" v-on:change="onselectKeyTypeChange()"
                   placeholder="请选择">
          <el-option
            v-for="item in selectTypeOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-select v-model="searchKey" class="searchKey" :filter-method="onInputSearchKey" filterable
                   placeholder="其输入搜索值">
          <el-option
            v-for="item in searchMatchKeys"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </div>
    </div>
    <div></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "EmailSent",
  data() {
    return {
      selectType: 'nice_name',
      selectTypeOptions: [{
        value: 'nice_name',
        label: '昵称'
      }, {
        value: 'phone',
        label: '用户电话'
      }, {
        value: 'user_email',
        label: '用户邮箱'
      }, {
        value: 'user_role',
        label: '用户角色'
      }],
      searchMatchKeys: [{
        value: '选项1',
        label: '黄金糕'
      }],
      searchKey: ''
    }
  },
  mounted() {
    /**初始化选择框选项*/
    this.updateSearchSelect('')
  },
  methods: {
    onselectKeyTypeChange() {
      this.updateSearchSelect('')
    },
    onInputSearchKey(key) {
     this.updateSearchSelect(key)
    },
    updateSearchSelect(key) {
      axios.get("http://localhost:8080/api/family_user/user_query", {
        params: {
          "col_name": this.selectType,
          "key": key
        }
      }).then(resp => {
        this.searchMatchKeys = []
        var respData = resp.data
        for (var i = 0; i < respData.length; i++) {
          var tmp_value = (respData[i])[this.selectType]
          var user_id = (respData[i])['user_id']
          var tmp = {"value": user_id, "label": tmp_value}
          console.log(tmp)
          this.searchMatchKeys.push(tmp)
        }
      })
    }
  }
}
</script>

<style scoped>
.selectType {
  width: 150px;
}

.searchKey {
  width: 700px;
}

</style>
