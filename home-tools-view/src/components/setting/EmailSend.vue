<template>
  <div>
    <div class="search_div">
      <div style="margin-top: 15px;">
        <el-card class="box-card" style="width: 1000px">
          <div slot="header" class="clearfix">
            <span>用户搜索</span>
          </div>
          <div style="margin-bottom: 30px">
            <el-select v-model="selectType" clearable class="selectType" v-on:change="onselectKeyTypeChange()"
                       placeholder="请选择">
              <el-option
                v-for="item in selectTypeOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
            <el-select v-model="searchKey" class="searchKey" :filter-method="onInputSearchKey"
                       v-on:change="onSelectUser()"
                       filterable
                       placeholder="其输入搜索值">
              <el-option
                v-for="item in searchMatchKeys"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
            <div class="select_object_div">
              <div class="select_object_item" style="width: 150px">昵称：{{ this.show_nice_name }}</div>
              <div class="select_object_item" style="width: 200px">电话号码：{{ this.show_phone }}</div>
              <div class="select_object_item" style="width: 600px">邮箱：{{ this.show_email }}</div>
            </div>
          </div>
        </el-card>

      </div>

    </div>
    <div class="send_email_config">
      <el-card class="box-card" style="width: 1000px">
        <div slot="header" class="clearfix">
          <span>邮件内容配置</span>
        </div>
        <div class="">
          <div>
            <el-table :data="stock_table_data" :row-class-name="tableRowClassName">
              <el-table-column prop="stock_code" label="股票代码" width="180"></el-table-column>
              <el-table-column prop="stock_name" label="公司名称" width="180"></el-table-column>
              <el-table-column prop="stock_holding_change" label="大股东持股变更">
                <template slot-scope="scope">
                  <el-switch v-model="stock_holding_change[scope.index]" active-text="开" inactive-text="关"></el-switch>
                </template>
              </el-table-column>
              <el-table-column prop="stock_holding_change_senior_managerment" label="高管持股变更">
                <template slot-scope="scope">
                  <el-switch v-model="stock_holding_change_senior_managerment[scope.index]" active-text="开"
                             inactive-text="关"></el-switch>
                </template>
              </el-table-column>
              <el-table-column prop="company_announcement" label="企业公告">
                <template slot-scope="scope">
                  <el-switch v-model="company_announcement[scope.index]" active-text="开" inactive-text="关"></el-switch>
                </template>
              </el-table-column>
              <el-table-column prop="option" label="删除">
                <template slot-scope="scope">
                  <el-button type="danger" icon="el-icon-delete" circle></el-button>
                </template>
              </el-table-column>
            </el-table>
            <div class="stock_search" v-if="stock_search_is_show">
              <el-select v-model="stock_search_type" clearable class="selectType" placeholder="请选择">
                <el-option
                  v-for="item in stock_search_type_option"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
              <el-select v-model="stock_search_key" style="width: 600px" :filter-method="onInputSearchStockKey"
                         filterable placeholder="其输入搜索值">
                <el-option
                  v-for="item in stock_search_match_keys"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
              <el-button type="success" style="width: 100px;" v-on:click="addStockToTable" plain>添加</el-button>
            </div>
            <el-button type="success" style="width: 860px" v-on:click="show_stock_search_div"
                       icon="el-icon-circle-plus-outline"></el-button>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: "EmailSent",
    data() {
      return {
        value1: true,
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
        searchMatchKeys: [{}],
        searchKey: '',
        show_nice_name: '',
        show_phone: '',
        show_email: '',
        stock_table_data: [{
          "stock_code": "100001",
          "stock_name": "晨鸣造纸"
        }],
        stock_holding_change_senior_managerment: [],
        stock_holding_change: [],
        company_announcement: [],
        stock_search_type: 'stock_code',
        stock_search_type_option: [
          {
            value: 'stock_code',
            label: '股票代码'
          }, {
            value: 'stock_name',
            label: '公司名称'
          }
        ],
        stock_search_key: '',
        stock_search_match_keys: [],
        stock_search_is_show: false
      }
    },
    mounted() {
      /**初始化选择框选项*/
      this.updateSearchSelect('')
    },
    methods: {
      show_stock_search_div() {
        this.stock_search_is_show = true
      },
      tableRowClassName() {

      },
      onselectKeyTypeChange() {
        this.updateSearchSelect('')
      },
      onInputSearchKey(key) {
        this.updateSearchSelect(key)
      },
      onSelectUser() {
        console.log("searchKey:" + this.searchKey)
        axios.get("http://localhost:8080/api/family_user/queryUserById", {
          params: {
            "user_id": this.searchKey
          }
        }).then(resp => {
          let users = resp.data
          if (users.length > 0) {
            let selectObject = users[0]
            this.show_email = selectObject['user_email']
            this.show_phone = selectObject['phone']
            this.show_nice_name = selectObject['nice_name']
            console.log(selectObject)
          }
        })
      },
      onInputSearchStockKey(stock_key) {
        axios.get("http://localhost:8080/api/family_user/qeuryStockDetailByColName", {
          params: {
            "col_name": this.stock_search_type,
            "col_value": stock_key
          }
        }).then(resp => {
          this.stock_search_match_keys = []
          let respData = resp.data
          console.log(respData)
          for (let i = 0; i < respData.length; i++) {
            let colValue = (respData[i])[this.stock_search_type]
            let stock_detail_id = (respData[i])['stock_detail_id']
            let tmp = {"value": stock_detail_id, "label": colValue}
            console.log(tmp)
            this.stock_search_match_keys.push(tmp)
          }
        })
      },
      addStockToTable() {
        axios.get("http://localhost:8080/api/family_user/queryStockByStockDetailId", {
          params: {
            "stock_detail_id": this.stock_search_key
          }
        }).then(resp => {
          this.searchMatchKeys = []
          let respData = resp.data
          if (respData.length > 0) {
            let stock_code = respData[0]['stock_code']
            let stock_name = respData[0]['stock_name']
            this.stock_table_data.push({
              "stock_code": stock_code,
              "stock_name": stock_name
            })
          }
        })
        this.stock_search_is_show = false
      },
      updateSearchSelect(key) {
        axios.get("http://localhost:8080/api/family_user/user_query", {
          params: {
            "col_name": this.selectType,
            "key": key
          }
        }).then(resp => {
          this.searchMatchKeys = []
          let respData = resp.data
          for (let i = 0; i < respData.length; i++) {
            let tmp_value = (respData[i])[this.selectType]
            let user_id = (respData[i])['user_id']
            let tmp = {"value": user_id, "label": tmp_value}
            this.searchMatchKeys.push(tmp)
          }
        })
      }
    }
  }
</script>

<style scoped>
  .select_object_item {
    float: left;
  }

  .select_object_div {
    margin-top: 15px;
  }

  .selectType {
    width: 150px;
  }

  .search_div {
    margin-top: 10px;
  }

  .searchKey {
    width: 800px;
  }

</style>
