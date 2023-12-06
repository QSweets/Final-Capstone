<template>
  <div class="home">
    <h1>Home</h1>
    <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
  </div>
</template>

<script>
export default {
  
};
</script>
