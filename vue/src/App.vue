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
  top: 1.2vh;
  width: 9vh;
}
.profile, .vote { 
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  border: solid 1px;
  position: relative;
  right: .8vh;
  top: 10.7vh;
  padding: 1vh;
  width: 15vh;
}
.r-monster {
  display: flex;
  position: absolute;
  bottom: 10.5vh;
  right: 44%;
}
.blank-box {
  border: solid 2px;
  position: absolute;
  width: 12%;
  height: 60%;
  top: 24%;
}
#welcome {
  display: flex;
  position: absolute;
  bottom: 82.5vh;
  right: 40%;
}
#logo {
  display: flex;
  position: absolute;
  bottom: 88.8vh;
  border: solid;
  width: 100%;
  justify-content: center;
  background-color: blue;
}
button:hover {
  border-color: rgb(70, 70, 245);
}
.m-stats {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: start;

  width: 87%;
  top: 14.4%;
  position: absolute;
  left: 17vh;
}
#m-name, #m-size, #m-challenge {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  border: solid 2px;
}
.home{
  display: flex;
  flex-direction: row-reverse;
  position: relative;
  top: 6.9vh;
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