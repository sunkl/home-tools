<template>
  <div>
    <div style="width: 100px ">
      <el-select v-model="scraw_id_select"
                 style=" height: 100px;width: 200px"
                 :filter-method="searchScrawName"
                 v-on:change="scraw_name_change"
                 filterable
                 placeholder="其输入搜索值">
        <el-option
          v-for="item in scraw_name_opt"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </div>
    <div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>基本配置</span>
        </div>
        <div>
          <table>
            <tr>
              <td colspan="2">
                <el-input placeholder="请输入内容" v-model="scraw_url" style="width: 500px">
                  <template slot="prepend">Http://</template>
                </el-input>
              </td>
              <td style="width: 20px"></td>
              <td>
                写入类型
              </td>
              <td>
                <el-select v-model="persist_type" clearable placeholder="请选择">
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
                  <el-select v-model="db_name" clearable placeholder="请选择" v-bind:disabled="db_select_is_able"
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
                  <el-input v-model="db_name" placeholder="请输入内容" v-bind:disabled="db_input_is_able"
                            style="width: 350px"></el-input>
                </el-radio>
              </td>

            </tr>
            <tr>
              <td colspan="5">数据表
                <el-radio v-model="input_table_type" v-on:change="input_table_type_change"
                          label="input_table_type_select">
                  <el-select v-model="table_name" clearable placeholder="请选择" v-bind:disabled="table_select_is_able"
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
                  <el-input v-model="table_name" placeholder="请输入内容" v-bind:disabled="table_input_is_able"
                            style="width: 350px"></el-input>
                </el-radio>
              </td>
            </tr>
            <tr>
              <td colspan="5">
                <el-button type="success" style="width: 300px" v-on:click="submit_base_config">提交</el-button>
              </td>
            </tr>
          </table>
        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>url参数</span>
        </div>
        <el-table
          :data="scraw_params_opt"
          border
          style="width: 100%">
          <el-table-column
            prop="param_name"
            label="参数名称"
            width="300">
          </el-table-column>
          <el-table-column
            prop="param_value"
            label="参数值"
            width="300">
          </el-table-column>
          <el-table-column
            prop="delete"
            label="删除"
            width="100">
            <template slot-scope="scope">
              <el-button type="text" size="small">删除</el-button>
            </template>
          </el-table-column>
          <el-table-column
            prop="submit"
            label="提交"
            width="80">
            <div>
              <el-button type="success" style="width: 860px;margin-top: 15px" v-on:click="submit_new_params"
                         icon="el-icon-circle-plus-outline"></el-button>
            </div>
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

      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>结果类型</span>
        </div>
        <el-table
          :data="scraw_result_cols_opt"
          border
          style="width: 100%">
          <el-table-column
            prop="col_name"
            label="列名"
            width="100">
          </el-table-column>
          <el-table-column
            prop="col_data_type"
            label="类型"
            width="100">
          </el-table-column>
          <el-table-column
            prop="col_desc"
            label="描述"
            width="300">
          </el-table-column>
          <el-table-column
            prop="delete"
            label="删除"
            width="100">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row)" type="text" size="small">删除</el-button>
            </template>
          </el-table-column>
          <el-table-column
            prop="submit"
            label="提交"
            width="80">
            <template slot-scope="scope">
              <el-button type="text" size="small">提交</el-button>
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
            <td colspan="3">
              <el-button type="success" style="width: 300px" v-on:click="submit_new_col">提交</el-button>
            </td>
            <td colspan="2">
              <el-button type="success" style="width: 300px" v-on:click="cancel_new_col">取消</el-button>
            </td>
          </tr>
        </table>
        <div>
          <el-button type="success" style="width: 860px;margin-top: 15px" v-on:click="add_col"
                     icon="el-icon-circle-plus-outline"></el-button>
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
        scraw_id_select: "",
        scraw_url: "",
        scraw_params_opt: [],
        scraw_result_cols_opt: [],
        new_param_name: "",
        new_param_value: "",
        persist_type_opt: [{
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
        persist_type: "hive",
        input_db_type: "input_db_type_select",
        input_table_type: "input_table_type_select",
        db_select_is_able: false,
        db_input_is_able: true,
        table_select_is_able: false,
        table_input_is_able: true,
        db_name: "",
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
      submit_base_config(){
        let scraw_id = this.scraw_id_select
        let scraw_url= this.scraw_url
        let scraw_persist_type = this.persist_type
        let dbName =  this.db_name
        let tableName = this.table_name
        console.log("update scraw base config [id=" + scraw_id + "],url:" + scraw_url + ",persist_type:" + scraw_persist_type+",dbname:"+dbName+",tableName:"+tableName)
        axios.get("http://localhost:8080/api/setting/scraw_config/updateScrawBaseConfig", {
          params: {
            "scraw_id": scraw_id,
            "scraw_url": scraw_url,
            "scraw_persist_type": scraw_persist_type,
            "dbName": dbName,
            "tableName": tableName,
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
        console.log(resp_data["scraw_result_schema"])
        console.log(resp_data["scraw_params"])
        this.scraw_result_cols_opt = JSON.parse(resp_data["scraw_result_schema"])
        this.scraw_params_opt = JSON.parse(resp_data["scraw_params"])
        let persistConfig = JSON.parse(resp_data["scraw_persist_config"])
        this.scraw_url=persistConfig["scraw_url"]
        this.persist_type=persistConfig["scraw_persist_type"]
        this.db_name=persistConfig["scraw_db_name"]
        this.table_name=persistConfig["scraw_table_name"]
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
      }
    }
  }
</script>

<style scoped>
  /*div {
    border: 1px solid #F00;
  }*/

</style>
