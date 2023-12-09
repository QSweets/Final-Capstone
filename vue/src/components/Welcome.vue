<template>
  <div id="welcome">
    <h1>Welcome {{ this.$store.state.user.username }}</h1>
  </div>
</template> test

<style>
#welcome {
  grid-template-columns: 1fr;
  grid-template-rows: 1;
  grid-template-areas:
  "welcome welcome welcome";
  column-gap: 50px;
  row-gap: 50px;
  align-content: center;
  /* position: relative;
  bottom: 15vh; */
}
</style>