<template>
  <div id="login" class="login_div">
    <div class="input_div">
      <el-row>
        <el-input class="tex_input" v-model="username" prefix-icon="el-icon-s-custom" placeholder="请输入用户名">
        </el-input>
      </el-row>
    </div>
    <div class="input_div">
      <el-input class="tex_input" v-model="password" show-password="true" prefix-icon="el-icon-unlock" placeholder="请输入密码"></el-input>
    </div>
    <div class="input_div">
      <el-row>
        <el-button class="button_log" type="success" v-on:click="login" plain>登 &nbsp;录</el-button>
      </el-row>
    </div>
    <div><span class="error_msg">{{ this.errorMesg }}</span></div>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: "login",
    data() {
      return {
        username: "root",
        password: "root",
        respData: "",
        errorMesg: ""
      }
    },
    methods: {
      reset() {
        this.username = ""
        this.password = ""
        this.errorMesg = ""
      },
      login() {
        console.log("begin login ...")
        axios.get("http://localhost:8080/api/family_user/login", {
          params: {
            "username": this.username,
            "passwd": this.password
          }
        }).then(resp => {
          this.respData = resp.data.toString()
          if (this.respData == "") {
            this.errorMesg = "用户名或者密码错误！"
          }
          console.log("respdata:" + this.respData)
        })
      }
    }
  }
</script>

<style scoped>
  #login {
    margin:auto;
  }

  .error_msg {
    color: red;
  }

  .login_div {
    width: 300px;
  }

  .tex_input {
    width: 250px;
    font-size: 20px;
  }

  .button_log {
    width: 250px;
  }
  .input_div {
    margin-top: 10px;
  }
</style>
