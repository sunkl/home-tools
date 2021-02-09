<template>
  <div class="base_box">
    <div class="input_div">
      <el-input class="tex_input" v-model="username" prefix-icon="el-icon-user-solid" placeholder="请输入用户名"></el-input>
      <div class="valid_msd">
        <i class="el-icon-check valid_icon"></i>
      </div>
    </div>
    <div class="input_div">
      <el-input class="tex_input" v-model="user_role" prefix-icon="el-icon-user-solid"
                placeholder="请输入用户角色"></el-input>
    </div>
    <div class="input_div">
      <el-input class="tex_input" v-model="user_role" prefix-icon="el-icon-phone" placeholder="请输入电话号码"></el-input>
    </div>
    <div class="input_div">
      <el-input class="tex_input" v-model="birth_day" prefix-icon="el-icon-date" placeholder="请输入生日"></el-input>
    </div>
    <div class="input_div">
      <el-input class="tex_input" v-model="birth_day" prefix-icon="el-icon-key" placeholder="请输入密码"></el-input>
    </div>
    <div class="input_div">
      <el-input class="tex_input" v-model="birth_day" prefix-icon="el-icon-key" placeholder="请再次输入密码"></el-input>
    </div>
    <div class="input_div">
      <el-button class="button_log" type="success" plain>注册</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserRegister"
}
</script>

<style scoped>
.base_box {
  border: 1px solid #F00;
  align-content: center;
  text-align: center;
  margin: 0 auto;
}

.input_div {
  border: 1px solid #F00;
}

.tex_input {
  margin-top: 15px;
  width: 700px;
  justify-content: center;
  display: inline-block;
  text-align: center;

}

.valid_msd {
  border: 1px solid #F00;
  float: left;
  width: 100px;
}

.valid_icon {
  float: left;
  font-size: 20px;
  font-weight: bolder;
  color: #42b983;
}
</style>
