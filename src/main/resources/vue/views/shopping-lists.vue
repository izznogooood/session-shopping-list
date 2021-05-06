<template id="shopping-lists">
  <h1>SessionID: {{ $javalin.state.sessionId }}</h1>
</template>

<script>
  Vue.component("shopping-lists", {
    template: "#shopping-lists",
    vuetify: new Vuetify(),
    data: () => ({
      text: "World"
    })
  });
</script>

<style>

</style>