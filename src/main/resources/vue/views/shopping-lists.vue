<template id="shopping-lists">
  <h1>Hello {{ $javalin.state.user }}</h1>
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