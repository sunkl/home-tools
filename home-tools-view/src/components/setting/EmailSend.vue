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
                       v-on:focus="selectAllUser()"
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
    <div>
      <el-card class="box-card" style="width: 1000px">
        <div slot="header" class="clearfix">
          <span>基本条件配置</span>
        </div>

        <div style="margin-bottom: 30px">
          <table>
            <tr>
              <td>开始时间</td>
              <td>
                <div class="block">
                  <span class="demonstration"></span>
                  <el-date-picker
                    v-model="alert_start_date"
                    align="right"
                    type="date"
                    placeholder="开始日期"
                    value-format="yyyy-MM-dd"
                    v-on:change="upsert_base_config('alert_start_date',alert_start_date)">
                  </el-date-picker>
                </div>
              </td>
              <td width="70px"></td>
              <td>告警间隔</td>
              <td>
                <template>
                  <el-select v-model="alter_interval_hour"
                             v-on:change="upsert_base_config('alter_interval_hour',alter_interval_hour)"
                             placeholder="告警间隔">
                    <el-option
                      v-for="item in [{'lable':'1','value':'1'},{'lable':'2','value':'2'},{'lable':'3','value':'3'},{'lable':'4','value':'4'},{'lable':'5','value':'5'}]"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                  小时
                </template>
              </td>
            </tr>
            <tr>
              <td>开始时间</td>
              <td>
                <div style="float: left">
                  <el-time-select
                    v-on:change="upsert_base_config('alter_start_time',alter_start_time)"
                    v-model="alter_start_time"
                    :picker-options="{ start: '08:30',  step: '00:15',  end: '18:30' }"
                    placeholder="开始时间">
                  </el-time-select>
                </div>
              </td>
              <td></td>
              <td>结束时间</td>
              <td>
                <div style="float: left">
                  <el-time-select
                    v-on:change="upsert_base_config('alter_end_time',alter_end_time)"
                    v-model="alter_end_time"
                    :picker-options="{ start: '08:30',  step: '00:15',  end: '18:30' }"
                    placeholder="结束时间">
                  </el-time-select>
                </div>
              </td>
            </tr>
            <tr>
              <td>邮件告警</td>
              <td>
                <el-switch
                  style="display: block"
                  v-model="email_alter_enable"
                  v-on:change="upsert_base_config('email_alter_enable',email_alter_enable)"
                  active-color="#13ce66"
                  inactive-color="#ff4949"
                  inactive-text="关"
                  active-text="开">
                </el-switch>
              </td>
            </tr>
          </table>
        </div>
      </el-card>
    </div>
    <div class="send_email_config">
      <el-card class="box-card" style="width: 1000px">
        <div slot="header" class="clearfix">
          <span>股票监控配置</span>
        </div>
        <div class="">
          <div>
            <el-table :data="stock_table_data" :row-class-name="tableRowClassName">
              <el-table-column prop="stock_code" label="股票代码" width="180"></el-table-column>
              <el-table-column prop="stock_name" label="公司名称" width="180"></el-table-column>
              <el-table-column prop="stock_holding_change" label="大股东持股变更">
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.stock_holding_change"
                             v-on:change="switch_change(scope.row.stock_code,'stock_holding_change',scope.row.stock_holding_change)"
                             active-text="开" inactive-text="关"></el-switch>
                </template>
              </el-table-column>
              <el-table-column prop="stock_holding_change_senior_manager" label="高管持股变更">
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.stock_holding_change_senior_manager"
                             v-on:change="switch_change(scope.row.stock_code,'stock_holding_change_senior_manager',scope.row.stock_holding_change_senior_manager)"
                             active-text="开"
                             inactive-text="关"></el-switch>
                </template>
              </el-table-column>
              <el-table-column prop="company_announcement" label="企业公告">
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.company_announcement"
                             v-on:change="switch_change(scope.row.stock_code,'company_announcement',scope.row.company_announcement)"
                             active-text="开" inactive-text="关"></el-switch>
                </template>
              </el-table-column>
              <el-table-column prop="detele_stock" label="删除">
                <template slot-scope="scope">
                  <el-button type="danger" icon="el-icon-delete" v-on:click="deleteStockRow(scope.row.stock_code)"
                             circle></el-button>
                </template>
              </el-table-column>
            </el-table>
            <div class="stock_search" style="{margin-top: 15px }" v-if="stock_search_is_show">
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
            <el-button type="success" style="width: 860px;margin-top: 15px" v-on:click="show_stock_search_div"
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
        stock_table_data: [],
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
        stock_search_is_show: false,
        tmp_stock_detail_object: {},
        alert_start_date: '',
        alter_start_time: '',
        alter_end_time: '',
        alter_interval_hour: '',
        email_alter_enable: true,
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
      selectAllUser() {
        this.updateSearchSelect('')
      },
      query_item_msg(user_id, item_type) {
        if (this.searchKey !== '') {
          console.log("查询基本配置，item_type:" + item_type + ",user_id:" + user_id)
          axios.get("http://localhost:8080/api/family_user/setting/emailSendConfig/queryItemMsgByUserIdItemType", {
            params: {
              "item_type": item_type,
              "user_id": user_id,
            }
          }).then(resp => {
            console.log("完成更新基本配置，item_type:" + item_type + ",user_id:" + user_id)
            this.reflush_base_config(item_type, resp.data)
          })
        }
      },
      reflush_base_config(item_type, itme_value) {
        if (item_type === 'alert_start_date') {
          this.alert_start_date = itme_value
        } else if (item_type === 'alter_interval_hour') {
          this.alter_interval_hour = itme_value
        } else if (item_type === 'alter_start_time') {
          this.alter_start_time = itme_value
        } else if (item_type === 'alter_end_time') {
          this.alter_end_time = itme_value
        } else if (item_type === 'email_alter_enable') {
          this.email_alter_enable = itme_value
        }
      },
      upsert_base_config(item_type, item_msg) {
        console.log("更新基本配置，user_id:" + this.searchKey + ",item_type:" + item_type + ",item_msg:" + item_msg)
        if (this.searchKey !== '' && item_msg !== '') {
          axios.get("http://localhost:8080/api/family_user/setting/emailSendConfig/updateEmailSendBaseConfig", {
            params: {
              "item_type": item_type,
              "user_id": this.searchKey,
              "item_msg": item_msg
            }
          }).then(resp => {
            console.log("完成更新基本配置，item_type:" + item_type + ",item_msg:" + item_msg)
            this.reflush_base_config(item_type, resp.data)
          })
        }
      },
      switch_change(stock_code, item_type, switch_value) {
        console.log("switch change stock_code:" + stock_code + ",item_type:" + item_type + ",switch_value:" + switch_value)
        axios.get("http://localhost:8080/api/family_user/setting/emailSendConfig/updateStockCodeItemSwitch", {
          params: {
            "stock_code": stock_code,
            "item_type": item_type,
            "switch_value": switch_value,
            "user_id": this.searchKey
          }
        }).then(resp => {
          this.stock_table_data = resp.data
          console.log("完成删除，重新刷新数据：user_id=" + this.searchKey + ",data:")
          console.log(resp.data)
        })
      },
      deleteStockRow(stock_code) {
        console.log("删除行数： stock_code=" + stock_code + ",user_id:" + this.searchKey)
        axios.get("http://localhost:8080/api/family_user/setting/emailSendConfig/deleteStockRow", {
          params: {
            "stock_code": stock_code,
            "user_id": this.searchKey
          }
        }).then(resp => {
          this.stock_table_data = resp.data
          console.log("完成删除，重新刷新数据：user_id=" + this.searchKey + ",data:")
          console.log(resp.data)
        })
      },
      onSelectUser() {
        /*请求详细用户信息并填充*/
        console.log("开始查询用户信息，userID=" + this.searchKey)
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
            console.log("用户信息查询完成，email:" + this.show_email + ",phone:" + this.show_phone + ",nice_name:" + this.show_nice_name)
          } else {
            console.log("用户信息查询完成,未查询到合适的用户信息！")
          }
        })
        console.log("开始查询用户邮件配置信息，userID=" + this.searchKey)
        /*请求用户邮件配置信息*/
        axios.get("http://localhost:8080/api/family_user/setting/emailSendConfig/queryAllConfigByUserId", {
          params: {
            "user_id": this.searchKey
          }
        }).then(resp => {
          this.stock_table_data = resp.data
          console.log("完成用户配置信息查询user_id=" + this.searchKey + ",data:")
          console.log(resp.data)
        })
        /**查询基本配置*/
        this.query_item_msg(this.searchKey, 'alert_start_date')
        this.query_item_msg(this.searchKey, 'alter_interval_hour')
        this.query_item_msg(this.searchKey, 'alter_start_time')
        this.query_item_msg(this.searchKey, 'alter_end_time')
        this.query_item_msg(this.searchKey, 'email_alter_enable')
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
            this.stock_search_match_keys.push(tmp)
          }
        })
      },
      addStockToTable() {
        let user_id = this.searchKey
        if (user_id !== '') {
          axios.get("http://localhost:8080/api/family_user/queryStockByStockDetailId", {
            params: {
              "stock_detail_id": this.stock_search_key
            }
          }).then(resp => {
            this.searchMatchKeys = []
            let respData = resp.data
            if (respData.length > 0) {
              this.tmp_stock_detail_object = respData[0]
              this.tmp_stock_detail_object.stock_holding_change = true
              this.tmp_stock_detail_object.stock_holding_change_senior_manager = true
              this.tmp_stock_detail_object.company_announcement = true
            }
          })
          let stock_detail_id = this.stock_search_key
          axios.get("http://localhost:8080/api/family_user/setting/emailSendConfig/upsertAllItemEmpy", {
            params: {
              "stock_detail_id": stock_detail_id,
              "user_id": user_id
            }
          }).then(resp => {
            console.log(resp.data)
            if (resp.data === 3) {
              this.stock_table_data.push(this.tmp_stock_detail_object)
            }
          })
          this.stock_search_is_show = false
        } else {
          alert("请选择操作用户！")
        }
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
