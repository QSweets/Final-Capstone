<template>
  <div id="login" class="login-container">
    <form v-on:submit.prevent="login">
      <h1 class="register" id="signInText">Who enters the dungeon!</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group" id="user">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group" id="pass">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div>
        <!-- <img class="container" src="../loginImages/LoginBG3.png" alt="big ol dude fr" /> -->
      </div>
      <button class="register" type="submit">Sign in</button>
      <p>
      <router-link class="register" v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {

      const lowercaseUsername = this.user.username.toLowerCase();
      const userWithLowercaseUsername = { ...this.user, username: lowercaseUsername };

      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.login-container {
  background-image: url('../loginImages/LoginBG2.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  min-height: 100vh;
}
.container{
  position: relative;
  left: 48%;
  top: 51vh;
  border: solid 2px;
}
#signInText {
  width: 22vh;
}
.register {
  position: relative;
  left: 42.5%;
  top: 55vh;
}
#user {
  display: grid;
  grid-template-columns: 15%;
  color: white;
  justify-content: center;
}
#pass {
  display: grid;
  grid-template-columns: 15%;
  color: white;
  justify-content: center;
}
.form-input-group {
  position: relative;
  top: 55vh;
  grid-template-columns: 10%;
}
label {
  margin-right: 0.5rem;
 
}
</style>

