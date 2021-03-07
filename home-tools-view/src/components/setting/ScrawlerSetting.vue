<template>
  <div>
    <div style="width: 100px ">
      <el-select v-model="scraw_name_input"
                 style=" height: 100px;width: 200px"
                 :filter-method="searchScrawName"
                 filterable
                 placeholder="其输入搜索值">
        <el-option
          v-for="item in scraw_opt"
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
          <table  >
            <tr>
              <td colspan="2">
                <el-input placeholder="请输入内容" v-model="scraw_name_input" style="width: 500px">
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
                  <el-select v-model="db_name" clearable placeholder="请选择" v-bind:disabled="db_select_is_able" style="width: 350px">
                    <el-option
                      v-for="item in db_name_search_result"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-radio>
                <el-radio v-model="input_db_type" v-on:change="input_db_type_change" label="input_db_type_input">
                  <el-input v-model="db_name" placeholder="请输入内容" v-bind:disabled="db_input_is_able" style="width: 350px"></el-input>
                </el-radio>
              </td>

            </tr>
            <tr>
              <td colspan="5">数据表
                <el-radio v-model="input_table_type" v-on:change="input_table_type_change"
                          label="input_table_type_select">
                  <el-select v-model="table_name" clearable placeholder="请选择" v-bind:disabled="table_select_is_able" style="width: 350px">
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
                  <el-input v-model="table_name" placeholder="请输入内容" v-bind:disabled="table_input_is_able" style="width: 350px"></el-input>
                </el-radio>

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
          :data="scraw_params"
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
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>结果类型</span>
        </div>
        <el-table
          :data="scraw_params"
          border
          style="width: 100%">
          <el-table-column
            prop="colName"
            label="列名"
            width="100">
          </el-table-column>
          <el-table-column
            prop="colValue"
            label="类型"
            width="100">
          </el-table-column>
          <el-table-column
            prop="colDesc"
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
      </el-card>
    </div>
    <div>

    </div>
  </div>
</template>

<script>
export default {
  name: "ScrawlerSetting",
  data() {
    return {
      scraw_name_input: "",
      scraw_url: "",
      scraw_params: [{}],
      scraw_result_cols: [{}],
      persist_type_opt: [{
        label: "hive",
        value: "hive"
      }, {
        label: "mysql",
        value: "mysql"
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
      scraw_opt: [{
        label: "ddd",
        value: "ddd"
      }, {
        label: "ddd1",
        value: "ddd1"
      }]
    }
  },
  methods: {
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
    searchScrawName() {

    }
  }
}
</script>

<style scoped>
/*div {
  border: 1px solid #F00;
}*/

</style>
