<template>
  <div>
    <el-container>
      <el-header>
        <div v-bind:style="{float:'right'}">
          <el-color-picker v-model="back_ground_color" size="mini"></el-color-picker>
        </div>
        <div v-bind:style="{float:'right'}">
          <el-color-picker v-model="tex_color" size="mini"></el-color-picker>
        </div>
      </el-header>

      <el-container>
        <el-aside width="200px">
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
                <span>账单管理</span>
              </template>
              <el-menu-item-group class="two_stage">
                <template slot="title">家庭开支</template>
              </el-menu-item-group>
              <el-menu-item-group class="two_stage">
                <template slot="title">对公账务</template>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="3" class="one_stage">
              <template slot="title">
                <i class="el-icon-setting"></i>
                <span>设置</span>
              </template>

              <el-menu-item-group class="two_stage">
                <template slot="title">爬虫管理</template>
              </el-menu-item-group>
              <el-menu-item-group class="two_stage">
                <template slot="title">成员管理</template>
              </el-menu-item-group>
              <el-menu-item-group class="two_stage">
                <template slot="title">界面样式管理</template>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <ScrawlerSetting/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import ScrawlerSetting from "./components/setting/ScrawlerSetting";
export default {
  name: "AppMain",
  components: {ScrawlerSetting},
  data() {
    return {
      /*back_ground_color: '#545c64'*/
      back_ground_color: '#A73B05',
      tex_color: '#ffffff',
    }
  },
  methods: {
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
body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.el-header{
  background-color: #B3C0D1;
  color: #333;
/*  text-align: center;*/
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
/*  text-align: center;*/
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
/*  text-align: center;*/
  line-height: 750px;

}

/*.head {
  height: 60px;
  !*  background-color: #545c64;*!
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
}*/
</style>
