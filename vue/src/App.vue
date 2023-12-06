<template>
  <div id="capstone-app">
    <div id="nav" v-if="isLoggedIn">
      <router-link  v-bind:to="{ name: 'home' }">Home</router-link> &nbsp; | &nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

export default {
  computed: {
    isLoggedIn() {
      return this.$store.state.isLoggedIn;
    },
    
  },
};

<script>

/* <style>
#nav {
  position: relative;
  top: 5vh;
  color: black;
  border: solid 2px;
} */

</style> 