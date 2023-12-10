<template>
  <header id="logo">
    <h1>This <span> is <i>a placement</i> holder for <i>Logo</i></span></h1>
  </header>
  <div class="logo-line"/>
</template>

<style>
#logo {
  display: flex;
  position: absolute;
  top: 0vh;
  left: .1vh;
  border: solid;
  width: 99.4%;
  height: 7.9%;
  justify-content: center;
  background-color: rgb(233, 184, 36);
}
.logo-line {
  border: solid 4px;
  width: 99.4%;
  position: absolute;
  top: 8.5vh;
  border-color: rgb(216, 63, 49);
}
</style>