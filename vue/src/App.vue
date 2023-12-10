<template>
  <div id="capstone-app">
    <div id="nav" v-if="isLoggedIn">
      <router-link  v-bind:to="{ name: 'home' }">Home</router-link> &nbsp; | &nbsp;
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
    
  },
};
</script>

<style>
.profile-link, .logout-link {
  display: flex;
  justify-content: flex-end;
  flex-direction: row;
  position: relative;
  left: 93.2%;
  top: 4.2vh;
  width: 9vh;
}
#welcome {
  display: flex;
  position: absolute;
  bottom: 82.5vh;
  right: 40%;
}
.home{
  display: flex;
  flex-direction: row-reverse;
  position: absolute;
  top: 10.8vh;
  border-bottom: solid 1px;
  width: 7%;
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