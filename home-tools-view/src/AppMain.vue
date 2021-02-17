<template>
  <div>
    <div class="head" v-bind:style="{'background-color':back_ground_color}">
      <div v-bind:style="{float:'right'}" >
        <el-color-picker v-model="back_ground_color" size="mini"></el-color-picker>
      </div>
      <div v-bind:style="{float:'right'}">
        <el-color-picker v-model="tex_color" size="mini"></el-color-picker>
      </div>
      <div>

      </div>
    </div>
    <el-row class="tac">
      <el-col :span="3" class="left_div" v-bind:style="{'background-color':back_ground_color}">
        <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                 v-bind:background-color="back_ground_color" v-bind:text-color="tex_color" active-text-color="#ffd04b">
          <el-submenu index="1" class="one_stage">
            <template slot="title">
              <i class="el-icon-s-data"></i>
              <span>证券信息</span>
            </template>
            <el-menu-item-group class="two_stage">
              <template slot="title">持股信息变更</template>
            </el-menu-item-group>
            <el-menu-item-group class="two_stage">
              <template slot="title">财报信息</template>
            </el-menu-item-group>
            <el-menu-item-group class="two_stage">
              <template slot="title">资产报表</template>
            </el-menu-item-group>
            <el-menu-item-group class="two_stage">
              <template slot="title">管理层变更</template>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2" class="one_stage">
            <template slot="title">
              <i class="el-icon-notebook-1"></i>
              <span>家庭账单</span>
            </template>
          </el-submenu>

          <el-submenu index="3" class="one_stage">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>设置</span>
            </template>
            <el-menu-item-group class="two_stage">
              <template slot="title">成员管理</template>
            </el-menu-item-group>
            <el-menu-item-group class="two_stage">
              <template slot="title">界面样式管理</template>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-col>
      <el-col background-color="#545c64">
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "AppMain",
  data() {
    return {
      /*back_ground_color: '#545c64'*/
      back_ground_color: '#A73B05',
      tex_color: '#ffffff'
    }
  },
  methods: {
    backgroudColorChange() {
      this.$refs.head.attributes.ba
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
      this.$refs.head.c
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.head {
  height: 60px;
  /*  background-color: #545c64;*/
  margin-bottom: 1px;
}

.left_div {
  height: 1000px;
}

.one_stage {
  text-align: left;
  margin-left: 20px;
}

.two_stage {
  text-align: left;
  margin-left: 15px;
}
</style>
