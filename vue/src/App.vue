<template>
  <div id="capstone-app">
    <div id="nav" v-if="isLoggedIn">
       &nbsp; | &nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>

</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      return this.$store.state.isLoggedIn;
    },
    notification() {
      return this.$store.state.notification;
    },
    notificationClass() {
      return {
        'status-message': true,
        error: this.notification?.type?.toLowerCase() === 'error',
        success: this.notification?.type?.toLowerCase() === 'success'
      };
    }
  },
  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    }
  }
};
</script>

<style>
#background {
  background-image: url('src/ProfileImages/background.jpg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  min-height: 100vh;
}
#welcome {
  display: flex;
  position: absolute;
  bottom: 82.5vh;
  right: 40%;
  color: white;
  border-bottom: solid 5px;
  border-color: rgb(33, 156, 144);
}
.home-header{
  display: flex;
  position: absolute;
  top: 9.6vh;
  left: .3%;
  color: white;
  text-decoration: underline rgb(33, 156, 144);
  width: 6%;
}
html {
  font: 62.5% / 1.15 sans-serif;
}
body{
  width: 100%;
  margin: 0 auto;
  font:
    1.6rem/1.25 "Helvetica Neue",
    Helvetica,
    Arial,
    sans-serif;
  background-color: #f5f5f5;
}
</style>