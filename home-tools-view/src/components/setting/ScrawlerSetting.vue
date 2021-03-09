<template>
  <div>
    <div>
      <el-card class="box-card">
        <div slot="header" class="clearfix" v-on:click="open_or_close_base_config">
          <span>基本配置
            <i class="el-icon-arrow-right"
               v-show="is_show_base_config_close_icon"></i>
            <i class="el-icon-arrow-down"
               v-show="is_show_base_config_open_icon"></i>
          </span>
        </div>
        <div v-show="is_show_base_config">
          <table>
            <tr>
              <td>
                <span>爬虫名字&nbsp;&nbsp;</span>
                <el-radio v-model="create_or_update" v-on:change="change_create_or_update" label="update">
                  <el-select v-model="scraw_id_select" style="  width: 333px" v-bind:disabled="update_is_able"
                             icon="el-icon-search"
                             :filter-method="searchScrawName" v-on:change="scraw_name_change" filterable
                             v-on:focus="searchScrawName('')"
                             placeholder="请输入搜索值">
                    <el-option v-for="item in scraw_name_opt" :key="item.value" :label="item.label"
                               :value="item.value"></el-option>
                  </el-select>

                </el-radio>
                <el-radio v-model="create_or_update" v-on:change="change_create_or_update" label="create">
                  <el-input v-model="create_scraw_name" placeholder="请输入内容" v-bind:disabled="create_is_able"
                            style="width: 333px"></el-input>
                </el-radio>
              </td>
            </tr>
            <tr>
              <td>
                <span>爬虫地址&nbsp;&nbsp;</span>
                <el-input placeholder="请输入内容" v-model="scraw_url" style="width: 750px">
                  <template slot="prepend">Http://</template>
                </el-input>
              </td>
            </tr>
            <tr>
              <td>
                <span>保存位置&nbsp;&nbsp</span>
                <el-select v-model="persist_type" placeholder="请选择保存位置">
                  <el-option
                    v-for="item in persist_type_opt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </td>
            </tr>
            <tr>
              <td colspan="5">数据库
                <el-radio v-model="input_db_type" v-on:change="input_db_type_change" label="input_db_type_select">
                  <el-select v-model="db_name_select" clearable placeholder="请选择" v-bind:disabled="db_select_is_able"
                             style="width: 350px">
                    <el-option
                      v-for="item in db_name_search_result"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-radio>
                <el-radio v-model="input_db_type" v-on:change="input_db_type_change" label="input_db_type_input">
                  <el-input v-model="db_name_input" placeholder="请输入内容" v-bind:disabled="db_input_is_able"
                            style="width: 350px"></el-input>
                </el-radio>
              </td>

            </tr>
            <tr>
              <td colspan="5">数据表
                <el-radio v-model="input_table_type" v-on:change="input_table_type_change"
                          label="input_table_type_select">
                  <el-select v-model="table_name_select" clearable placeholder="请选择"
                             v-bind:disabled="table_select_is_able"
                             style="width: 350px">
                    <el-option
                      v-for="item in table_name_search_result"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-radio>
                <el-radio v-model="input_table_type" v-on:change="input_table_type_change"
                          label="input_table_type_input">
                  <el-input v-model="table_name_input" placeholder="请输入内容" v-bind:disabled="table_input_is_able"
                            style="width: 350px"></el-input>
                </el-radio>
              </td>
            </tr>
            <tr>
              <td>
                <span>爬虫描述&nbsp;&nbsp;</span>
                <el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="scraw_desc"
                          style="width: 760px"></el-input>
              </td>
            </tr>
            <tr>
              <td>
                <span>起始时间&nbsp;&nbsp;</span>
                <el-time-select
                  v-model="action_start_time"
                  :picker-options="{  start: '00:00',   step: '00:30',  end: '23:31' }"
                  placeholder="选择首次触发时间">
                </el-time-select>
                <span>时间间隔</span>
                <el-input placeholder="请输入内容" v-model="action_frequency_num" style="width: 460px"
                          class="input-with-select">
                  <el-select v-model="action_frequency_unit" style="width: 70px" slot="prepend" placeholder="请选择">
                    <el-option label="时" value="hour"></el-option>
                    <el-option label="天" value="day"></el-option>
                    <el-option label="周" value="week"></el-option>
                    <el-option label="月" value="month"></el-option>
                    <el-option label="年" value="year"></el-option>
                  </el-select>
                </el-input>
              </td>

            </tr>
            <tr>
              <td>
                <el-button type="success" style="width:60px" v-on:click="delete_scraw"
                           icon="el-icon-delete"></el-button>
                <el-button type="success" style="width:60px" v-on:click="create_or_update_scraw_base_config"
                           :icon="update_or_create_icon"></el-button>
              </td>
            </tr>
          </table>
        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix" v-on:click="open_or_close_url_param">
          <span>url参数
            <i class="el-icon-arrow-right"
               v-show="is_show_url_param_close_icon"></i>
            <i class="el-icon-arrow-down"
               v-show="is_show_url_param_open_icon"></i></span>
        </div>
        <div v-show="is_show_url_param">
          <el-table
            :data="scraw_params_opt"
            border
            style="width: 100%">
            <el-table-column
              prop="param_index"
              label="序号"
              width="300">
            </el-table-column>
            <el-table-column
              prop="param_name"
              label="参数名称"
              width="300">
              <template slot-scope="scope">
                <el-input v-model="scope.row.param_name"
                          style="width: 160px"
                          v-on:change="update_url_param(scope.row.param_index,scope.row.param_name,'param_name')"
                          placeholder="请输入内容" clearable>
                </el-input>
              </template>
            </el-table-column>
            <el-table-column
              prop="param_value"
              label="参数值"
              width="300">
              <template slot-scope="scope">
                <el-input v-model="scope.row.param_value"
                          style="width: 160px"
                          v-on:change="update_url_param(scope.row.param_index,scope.row.param_value,'param_value')"
                          placeholder="请输入内容" clearable>
                </el-input>
              </template>
            </el-table-column>
            <el-table-column
              prop="delete"
              label="删除"
              width="100">
              <template slot-scope="scope">
                <el-button v-on:click="update_url_param(scope.row.param_index,scope.row.param_value,'param_delete')"
                           type="text" size="small">删除
                </el-button>
              </template>
            </el-table-column>

          </el-table>
          <div v-show="add_url_param_is_show">
            <div>
              <el-input placeholder="请输入内容" v-model="new_param_name" style="width: 350px;float: left">
                <template slot="prepend">参数名称</template>
              </el-input>
            </div>
            <div>
              <el-input placeholder="请输入内容" v-model="new_param_value" style="width: 450px;float: left">
                <template slot="prepend">参数值</template>
              </el-input>
            </div>
            <div>
              <el-button type="success" style="width: 100px" v-on:click="submit_new_params">提交</el-button>
            </div>
          </div>
          <div>
            <el-button type="success" style="width: 900px" v-on:click="add_url_params">添加参数</el-button>
          </div>
        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix" v-on:click="open_or_close_result_cols">
          <span>结果类型
            <i class="el-icon-arrow-right"
               v-show="is_show_result_cols_close_icon"></i>
            <i class="el-icon-arrow-down"
               v-show="is_show_result_cols_open_icon"></i>
          </span>

        </div>
        <div v-show="is_show_result_cols">
          <el-table
            :data="scraw_result_cols_opt"
            border
            style="width: 100%">
            <el-table-column v-show="false"
                             prop="col_index"
                             label="序号"
                             width="50">
            </el-table-column>
            <el-table-column
              prop="col_name"
              label="列名"
              width="200">
              <template slot-scope="scope">
                <el-input v-model="scope.row.col_name"
                          style="width: 160px"
                          v-on:change="update_result_col(scope.row.col_index,scope.row.col_name,'col_name')"
                          placeholder="请输入内容" clearable>
                </el-input>
              </template>
            </el-table-column>
            <el-table-column
              prop="col_data_type"
              label="类型"
              width="125">
              <template slot-scope="scope">
                <el-select v-model="scope.row.col_data_type"
                           v-on:change="update_result_col(scope.row.col_index,scope.row.col_data_type,'col_data_type')"
                           placeholder="请选择" style="width: 100px;">
                  <el-option
                    v-for="item in col_data_type_opt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </template>
            </el-table-column>
            <el-table-column
              prop="col_desc"
              label="描述"
              width="300">
              <template slot-scope="scope">
                <el-input v-model="scope.row.col_desc"
                          style="width: 275px;"
                          v-on:change="update_result_col(scope.row.col_index,scope.row.col_desc,'col_desc')"
                          type="textarea" :rows="2" placeholder="请输入内容">
                </el-input>
              </template>
            </el-table-column>
            <el-table-column
              prop="col_move_up"
              label="上移"
              width="70">
              <template slot-scope="scope">
                <el-button v-on:click="update_result_col(scope.row.col_index,'','move_up')"
                           type="info" icon="el-icon-top" circle></el-button>
              </template>
            </el-table-column>
            <el-table-column
              prop="col_move_down"
              label="下移"
              width="70">
              <template slot-scope="scope">
                <el-button v-on:click="update_result_col(scope.row.col_index,'','move_down')"
                           type="warning" icon="el-icon-bottom" circle></el-button>
              </template>
            </el-table-column>
            <el-table-column
              prop="col_delete"
              label="删除"
              width="70">
              <template slot-scope="scope">
                <el-button v-on:click="update_result_col(scope.row.col_index,'','col_delete')"
                           type="warning" icon="el-icon-delete" circle></el-button>
              </template>
            </el-table-column>

          </el-table>
          <table v-show="add_result_col_is_show">
            <tr>
              <td>列名称</td>
              <td>
                <el-input v-model="new_col_name" placeholder="请输入内容" style="width: 400px"></el-input>
              </td>
              <td style="width: 50px"></td>
              <td>
                类型
              </td>
              <td>
                <template>
                  <el-select v-model="new_col_data_type" placeholder="请选择" style="width: 300px;">
                    <el-option
                      v-for="item in col_data_type_opt"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </template>
              </td>
            </tr>
            <tr>
              <td>列描述</td>
              <td colspan="5">
                <el-input
                  type="textarea"
                  :rows="2"
                  placeholder="请输入内容"
                  v-model="new_col_desc">
                </el-input>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <el-button type="success" style="width: 300px" v-on:click="cancel_new_col">取消</el-button>
              </td>
              <td colspan="3">
                <el-button type="success" style="width: 300px" v-on:click="submit_new_col">提交</el-button>
              </td>
            </tr>
          </table>
          <div>
            <el-button type="success" style="width: 860px;margin-top: 15px" v-on:click="add_col"
                       icon="el-icon-circle-plus-outline"></el-button>
          </div>
        </div>

      </el-card>
    </div>
    <div>

    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ScrawlerSetting",
  data() {
    return {
      /*结果列配置显示*/
      is_show_result_cols_close_icon: true,
      is_show_result_cols_open_icon: false,
      is_show_result_cols: false,
      /*url参数配置窗口显示*/
      is_show_url_param_close_icon: true,
      is_show_url_param_open_icon: false,
      is_show_url_param: false,
      /*是否展示基础配置界面关闭图标*/
      is_show_base_config_close_icon: false,
      is_show_base_config_open_icon: true,
      is_show_base_config: true,
      /*爬虫触发起始时间*/
      action_start_time: "00:00",
      /*触发时间间隔数*/
      action_frequency_num: "0",
      /*触发时间间隔单位*/
      action_frequency_unit: "hour",
      update_or_create_icon: "el-icon-circle-plus-outline",
      create_or_update: "update",
      create_is_able: true,
      update_is_able: false,
      create_scraw_name: "",
      scraw_desc: "",
      scraw_id_select: "",
      scraw_url: "",
      scraw_params_opt: [],
      scraw_result_cols_opt: [],
      new_param_name: "",
      new_param_value: "",
      persist_type: "hive",
      persist_type_opt: [
        {
          label: "hive",
          value: "hive"
        }, {
          label: "mysql",
          value: "mysql"
        }
      ],
      col_data_type_opt: [
        {
          label: "string",
          value: "string"
        }, {
          label: "long",
          value: "long"
        }, {
          label: "double",
          value: "double"
        }, {
          label: "boolean",
          value: "boolean"
        }
      ],
      input_db_type: "input_db_type_select",
      input_table_type: "input_table_type_select",
      db_select_is_able: false,
      db_input_is_able: true,
      table_select_is_able: false,
      table_input_is_able: true,
      db_name_select: "",
      db_name_input: "",
      table_name_select: "",
      table_name_input: "",
      table_name: "",
      db_name_search_result: [],
      table_name_search_result: [],
      scraw_name_opt: [],
      add_url_param_is_show: false,
      add_result_col_is_show: false,
      new_col_name: "",
      new_col_data_type: "",
      new_col_desc: ""
    }
  },
  methods: {
    update_url_param(param_index, param_value, update_type) {
      console.log("update url parma, param_index:" + param_index + ",param_value:" + param_value + ",update_type:" + update_type)
      let scraw_id = this.scraw_id_select
      axios.get("http://localhost:8080/api/setting/scraw_config/updateUrlParamByScrawId", {
        params: {
          "scraw_id": scraw_id,
          "parma_index": param_index,
          "param_value": param_value,
          "update_type": update_type
        }
      }).then(resp => {
        this.reflush_all_config(resp.data)
      })
    },
    update_result_col(col_index, col_param_value, col_param_type) {
      console.log("update col param： col_index:" + col_index + ",col_param_value:" + col_param_value + "col_param_type:" + col_param_type)
      let scraw_id = this.scraw_id_select
      axios.get("http://localhost:8080/api/setting/scraw_config/updateResultColByScrawId", {
        params: {
          "scraw_id": scraw_id,
          "col_index": col_index,
          "col_param_value": col_param_value,
          "col_param_type": col_param_type
        }
      }).then(resp => {
        this.reflush_all_config(resp.data)
      })
    },
    open_or_close_result_cols() {
      this.is_show_result_cols_close_icon = !this.is_show_result_cols_close_icon
      this.is_show_result_cols_open_icon = !this.is_show_result_cols_open_icon
      this.is_show_result_cols = !this.is_show_result_cols
    },
    open_or_close_url_param() {
      this.is_show_url_param_open_icon = !this.is_show_url_param_open_icon
      this.is_show_url_param_close_icon = !this.is_show_url_param_close_icon
      this.is_show_url_param = !this.is_show_url_param
    },
    open_or_close_base_config() {
      /*是否展示基础配置界面关闭图标*/
      this.is_show_base_config_close_icon = !this.is_show_base_config_close_icon
      /*是否展示基础配置界面打开图标*/
      this.is_show_base_config_open_icon = !this.is_show_base_config_open_icon
      /*是否展示基本配置界面*/
      this.is_show_base_config = !this.is_show_base_config
    },
    change_create_or_update() {
      if (this.create_or_update === "update") {
        this.create_is_able = true
        this.update_is_able = false
        this.update_or_create_icon = "el-icon-circle-plus-outline"
      } else {
        this.create_is_able = false
        this.update_is_able = true
        this.update_or_create_icon = "el-icon-edit"
      }
    },
    create_scraw() {
      console.log("create scraw scraw_name:" + this.create_scraw_name)
      axios.get("http://localhost:8080/api/setting/scraw_config/createScrawName", {
        params: {
          "scraw_name": this.create_scraw_name
        }
      }).then(resp => {
        console.log(resp.data)
        if (resp.data) {
          this.alertMessage("成功", "创建[" + this.create_scraw_name + "]成功!")
        } else {
          this.alertMessage("失败", "创建[" + this.create_scraw_name + "]失败，名称或已存在!")
        }
      })
    },
    delete_scraw() {
      axios.get("http://localhost:8080/api/setting/scraw_config/deleteById", {
        params: {
          "scraw_id": this.scraw_id_select
        }
      }).then(resp => {
        console.log(resp.data)
        if (resp.data) {
          this.alertMessage("成功", "删除成功!")
        } else {
          this.alertMessage("失败", "删除失败，名称或已存在!")
        }
      })
    },
    create_or_update_scraw_base_config() {
      let scraw_id = this.scraw_id_select
      let scraw_url = this.scraw_url
      let scraw_persist_type = this.persist_type
      let dbName = ""
      if (this.db_select_is_able) {
        dbName = this.db_name_input
      } else {
        dbName = this.db_name_select
      }
      let tableName = ""
      if (this.table_select_is_able) {
        tableName = this.table_name_input
      } else {
        tableName = this.table_name_select
      }
      let create_or_update = this.create_or_update
      let scraw_desc = this.scraw_desc
      let scraw_action_start_time = this.action_start_time
      let action_frequency_num = this.action_frequency_num
      let action_frequency_unit = this.action_frequency_unit

      console.log("update scraw base config [id=" + scraw_id + "] \n  url:" + scraw_url + "  \n  persist_type:" +
        scraw_persist_type + " \n  dbname:" + dbName + " \n  tableName:" + tableName + "\n  create_or_update:" + create_or_update +
        "\n  scraw_desc:" + scraw_desc + "\n  scraw_action_start_time：" + scraw_action_start_time + "\n  action_frequency_num:" + action_frequency_num + "\n  action_frequency_unit:" + action_frequency_unit)
      axios.get("http://localhost:8080/api/setting/scraw_config/createOrUpdateBaseConfig", {
        params: {
          "scraw_id": scraw_id,
          "create_scraw_name": this.create_scraw_name,
          "scraw_url": scraw_url,
          "scraw_persist_type": scraw_persist_type,
          "create_or_update": create_or_update,
          "dbName": dbName,
          "tableName": tableName,
          "scraw_desc": scraw_desc,
          "scraw_action_start_time": scraw_action_start_time,
          "action_frequency_num": action_frequency_num,
          "action_frequency_unit": action_frequency_unit
        }
      }).then(resp => {
        this.reflush_all_config(resp.data)
      })
    },
    input_db_type_change() {
      if (this.input_db_type === "input_db_type_select") {
        this.db_select_is_able = false
        this.db_input_is_able = true
      } else {
        this.db_select_is_able = true
        this.db_input_is_able = false
      }
    },
    input_table_type_change() {
      if (this.input_table_type === "input_table_type_select") {
        this.table_select_is_able = false
        this.table_input_is_able = true
      } else {
        this.table_select_is_able = true
        this.table_input_is_able = false
      }
    },

    searchScrawName(key) {
      console.log("search like scraw name:" + key)
      axios.get("http://localhost:8080/api/setting/scraw_config/selectByLikeScrawName", {
        params: {
          "scraw_name": key
        }
      }).then(resp => {
        console.log(resp.data)
        this.scraw_name_opt = resp.data
      })
    },
    scraw_name_change() {
      console.log("search by scraw id:" + this.scraw_id_select)
      axios.get("http://localhost:8080/api/setting/scraw_config/selectById", {
        params: {
          "scraw_id": this.scraw_id_select
        }
      }).then(resp => {
        console.log(resp.data)
        this.reflush_all_config(resp.data)
      })
    },
    reflush_all_config(resp_data) {
      /** flush url */
      this.scraw_url = resp_data["scraw_base_url"]
      this.create_scraw_name=resp_data["scraw_name"]
      this.scraw_desc = resp_data["scraw_desc"]
      this.action_start_time = resp_data["scraw_action_start_time"]
      this.action_frequency_num = resp_data["action_frequency_num"]
      this.action_frequency_unit = resp_data["action_frequency_unit"]
      this.scraw_result_cols_opt = JSON.parse(resp_data["scraw_result_schema"])
      this.scraw_params_opt = JSON.parse(resp_data["scraw_params"])
      let persistConfig = JSON.parse(resp_data["scaw_persist_config"])
      this.persist_type = persistConfig["scraw_persist_type"]
      this.db_name_select = persistConfig["scraw_db_name"]
      this.db_name_input = persistConfig["scraw_db_name"]
      this.table_name_select = persistConfig["scraw_table_name"]
      this.table_name_input = persistConfig["scraw_table_name"]

      console.log("flush :action_start_time"+this.action_start_time)
    },
    add_url_params() {
      this.add_url_param_is_show = true
    },
    submit_new_params() {
      let new_url_param_name = this.new_param_name
      let new_url_param_value = this.new_param_value
      let scraw_id = this.scraw_id_select
      if (this.submit_check()) {
        console.log("add scraw[id=" + scraw_id + "],param_name:" + new_url_param_name + ",param_value:" + new_url_param_value)
        axios.get("http://localhost:8080/api/setting/scraw_config/addParamByScrawId", {
          params: {
            "scraw_id": scraw_id,
            "param_name": new_url_param_name,
            "param_value": new_url_param_value
          }
        }).then(resp => {
          this.reflush_all_config(resp.data)
          this.add_url_param_is_show = false
        })
      }

    },
    add_col() {
      this.add_result_col_is_show = true
    },
    submit_new_col() {
      let scraw_id = this.scraw_id_select
      let col_name = this.new_col_name
      let col_data_type = this.new_col_data_type
      let col_desc = this.new_col_desc
      if (this.submit_check()) {
        console.log("add or update col,scraw_id:" + scraw_id + ",colName:" + col_name + ",colDataType:" + col_data_type + ",colDesc:" + col_desc)
        axios.get("http://localhost:8080/api/setting/scraw_config/addUpdateResultCol", {
          params: {
            "scraw_id": scraw_id,
            "col_name": col_name,
            "col_data_type": col_data_type,
            "col_desc": col_desc
          }
        }).then(resp => {
          this.reflush_all_config(resp.data)
          this.add_result_col_is_show = false
        })
      }
    },
    cancel_new_col() {
      this.add_result_col_is_show = false
    },
    submit_check() {
      if (this.scraw_id_select === "") {
        this.alertMessage("提交失败", "请选择爬虫")
        return false
      }
      if (this.add_url_param_is_show && this.new_param_name === "") {
        this.alertMessage("提交失败", "参数名称不能为空")
        return false
      }
      if (this.add_url_param_is_show && this.new_param_value === "") {
        this.alertMessage("提交失败", "参数值不能为空")
        return false
      }
      if (this.add_result_col_is_show && this.new_col_name === "") {
        this.alertMessage("提交失败", "列明不能为空")
        return false
      }
      if (this.add_result_col_is_show && this.new_col_data_type === "") {
        this.alertMessage("提交失败", "数据类型不能为空")
        return false
      }
      /*        if(this.add_result_col_is_show && this.new_col_desc === ""){
                this.alertMessage("提交失败", "参数值不能为空")
              }*/
      return true
    },
    alertMessage(title, message) {
      const h = this.$createElement;
      this.$notify({
        title: title,
        message: h('i', {style: 'color: teal'}, message)
      });
      console.log("title:" + title + ",messg:" + message)
    }
  }
}
</script>

<style scoped>
/*div {
  border: 1px solid #F00;
}*/

</style>
