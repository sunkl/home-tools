<template>
  <div class="base_box">
    <div class="input_div" v-bind:style="{left:input_div_x+'px'}">
      <el-input class="tex_input" v-on:keydown="check_user_name" v-model="username" prefix-icon="el-icon-user-solid"
                placeholder="请输入用户名"></el-input>
      <el-input class="tex_input" v-on:keydown="check_user_rule" v-model="user_role" prefix-icon="el-icon-user-solid"
                placeholder="请输入用户角色"></el-input>
      <el-input class="tex_input" v-on:keydown="check_nice_name" v-model="nice_name" prefix-icon="el-icon-user-solid"
                placeholder="请输入昵称"></el-input>
      <el-input class="tex_input" v-on:keydown="check_user_phone" v-model="user_phone" prefix-icon="el-icon-phone"
                placeholder="请输入电话号码"></el-input>
      <el-input class="tex_input" v-on:keydown="" v-model="user_birth" prefix-icon="el-icon-date"
                placeholder="请输入生日"></el-input>
      <el-input class="tex_input" v-on:keydown="check_user_pass" v-model="user_pass" prefix-icon="el-icon-key"
                placeholder="请输入密码"></el-input>
      <el-input class="tex_input" v-on:keydown="check_user_pass_re" v-model="user_pass_re" prefix-icon="el-icon-key"
                placeholder="请再次输入密码"></el-input>
      <el-button class="button_log" v-on:click="click_submit" type="success" plain>注册</el-button>
    </div>
    <div class="valid_div" v-bind:style="{left:valid_div_x+'px'}">
      <div class="valid_true" v-if="user_name_check"><i class="el-icon-check el_icon_true"></i></div>
      <div class="valid_false" v-if="!user_name_check"><i class="el-icon-close el_icon_false"></i>
        <span class="error_message">{{ user_name_check_msg }}</span>
      </div>
      <div class="valid_true" v-if="user_role_check"><i class="el-icon-check el_icon_true"></i></div>
      <div class="valid_false" v-if="!user_role_check"><i class="el-icon-close el_icon_false"></i>
        <span class="error_message">{{ user_role_check_msg }}</span>
      </div>
      <div class="valid_true" v-if="nice_name_check"><i class="el-icon-check el_icon_true"></i></div>
      <div class="valid_false" v-if="!nice_name_check"><i class="el-icon-close el_icon_false"></i>
        <span class="error_message">{{ nice_name_check_msg }}</span>
      </div>
      <div class="valid_true" v-if="user_phone_check"><i class="el-icon-check el_icon_true"></i></div>
      <div class="valid_false" v-if="!user_phone_check"><i class="el-icon-close el_icon_false"></i>
        <span class="error_message">{{ user_phone_check_msg }}</span>
      </div>
      <div class="valid_true" v-if="user_birth_check"><i class="el-icon-check el_icon_true"></i></div>
      <div class="valid_false" v-if="!user_birth_check"><i class="el-icon-close el_icon_false"></i>
        <span class="error_message">{{ user_birth_check_msg }}</span>
      </div>
      <div class="valid_true" v-if="user_pass_check"><i class="el-icon-check el_icon_true"></i></div>
      <div class="valid_false" v-if="!user_pass_check"><i class="el-icon-close el_icon_false"></i>
        <span class="error_message"> {{ user_pass_check_msg }}</span>
      </div>
      <div class="valid_true" v-if="user_pass_re_check"><i class="el-icon-check el_icon_true"></i></div>
      <div class="valid_false" v-if="!user_pass_re_check">
        <i class="el-icon-close el_icon_false"></i>
        <span class="error_message">{{ user_pass_re_check_msg }}</span>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: "UserRegister",
    data() {
      return {
        username: "",
        user_role: "",
        user_phone: "",
        user_birth: "",
        user_pass: "",
        user_pass_re: "",
        nice_name:"",
        input_div_x: document.documentElement.clientWidth / 2 - 300,
        valid_div_x: document.documentElement.clientWidth / 2 + 300,
        user_name_check: true,
        user_role_check: true,
        user_phone_check: true,
        user_birth_check: true,
        user_pass_check: true,
        user_pass_re_check: true,
        nice_name_check: true,
        user_name_check_msg: "",
        user_role_check_msg: "",
        user_phone_check_msg: "",
        user_birth_check_msg: "",
        user_pass_check_msg: "",
        user_pass_re_check_msg: "",
        nice_name_check_msg:""
      }
    },
    methods: {
      check_user_name() {
        if (this.username == null || this.username === "") {
          this.user_name_check = false
          this.user_name_check_msg = "用户名称不能为空！"
        } else if (this.username.length < 4) {
          this.user_name_check = false
          this.user_name_check_msg = "用户名必须大于等于4个字符！"
        } else {
          this.user_name_check = true
        }
      },
      check_user_rule() {
        if (this.user_role == null || this.user_role === "") {
          this.user_role_check = false
          this.user_role_check_msg = "用户角色不能为空！"
        } else {
          this.user_role_check = true
        }
      },
      check_user_phone() {
        if (this.user_phone == null || this.user_phone === "") {
          this.user_phone_check = false
          this.user_phone_check_msg = "用户号码不能为空！"
        } else if (/^([0-9\\-]+)$/.test(this.user_phone)) {
          this.user_phone_check = true
        } else {
          this.user_phone_check_msg = "电话号码只能为数字或者-！"
          this.user_phone_check = false
        }
      },
      check_user_pass() {
        if (this.user_pass == null || this.user_pass === "") {
          this.user_pass_check = false
          this.user_pass_check_msg = "用户密码不能为空！"
        } else if (this.user_pass.length< 6) {
          this.user_pass_check_msg = "密码长度必须大于6！"
          this.user_pass_check = false
        } else {
          this.user_pass_check = true
        }
      },
      check_user_pass_re() {
        if (this.user_pass_re == null || this.user_pass_re === "") {
          this.user_pass_re_check = false
          this.user_pass_re_check_msg = "确认密码不能为空！"
        } else if (this.user_pass_re !== this.user_pass) {
          this.user_pass_re_check_msg = "两次密码输入不一致！"
          this.user_pass_re_check = false
        } else {
          this.user_pass_re_check = true
        }
      },
      check_nice_name() {
        if (this.nice_name == null || this.nice_name === "") {
          this.nice_name_check = false
          this.nice_name_check_msg = "昵称不能为空！"
        } else if (this.nice_name.length < 4) {
          this.nice_name_check = false
          this.nice_name_check_msg = "昵称必须大于等于4个字符！"
        } else {
          this.nice_name_check = true
        }
      },
      click_submit() {
        this.check_user_name()
        this.check_user_rule()
        this.check_user_phone()
        this.check_user_pass()
        this.check_user_pass_re()
        this.check_nice_name()
        if (this.user_name_check && this.user_role_check && this.user_phone_check && this.user_pass_check && this.user_pass_re_check) {
          console.log("检验通过")
          axios.get("http://localhost:8080/api/family_user/register", {
            params: {
              "username": this.username,
              "passwd": this.user_pass,
              "role": this.user_role,
              "birth_day": this.user_birth,
              "nice_name": this.nice_name,
              "phone": this.user_phone
            }
          }).then(resp => {
            this.respData = resp.data.toString()
            if (this.respData === "false") {
              this.errorMesg = "注册失败！"
            }else{
              this.$alert("用户名"+this.username+"注册成功，将跳转到登陆界面！","注册成功",{
                confirmButtonText:"确认",
                callback:action => {
                  this.$router.push("/")
                }
              })
            }
          })
        } else {
          console.log("校验不通过")
        }
      }
    }
  }
</script>

<style scoped>

  .button_log {
    margin-top: 10px;
    width: 600px;
  }

  .input_div {
    /*
        border: 1px solid #F00;*/
    width: 600px;
    position: absolute;
    top: 200px;
  }

  .tex_input {
    margin-top: 15px;
    width: 600px;
    justify-content: center;
    display: inline-block;
    text-align: center;

  }

  .valid_div {
    width: 300px;
    position: absolute;
    top: 200px;
  }

  .valid_true {
    margin-top: 14px;
    margin-left: 10px;
    width: 300px;
    text-align: left;
  }

  .el_icon_true {
    margin-left: 1px;
    font-size: 40px;
    color: green;
  }

  .valid_false {
    margin-top: 20px;
    margin-left: 10px;
    width: 300px;
    text-align: left;
  }

  .el_icon_false {
    margin-left: 1px;
    font-size: 35px;
    color: red;
    vertical-align: middle;
  }

  .error_message {
    color: red;
    font-family: 新宋体;
    font-style: oblique;
  }
</style>
