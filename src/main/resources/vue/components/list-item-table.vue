<template id="list-item-table">
  <v-simple-table>
    <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left table-small-column">
            Qty
          </th>
          <th class="text-left">
            Item
          </th>
          <th class="table-small-column">
            <!-- edit -->
          </th>
          <th class="table-small-column">
            <!-- delete -->
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
            v-for="(item, i) in $javalin.state.businesses[businessId].shoppingList"
            :key="i"
        >
          <td>{{ item.quantity }}</td>
          <td>{{ item.name }}</td>
          <td>
            <span style="font-size: 16px; color: dimgrey;">
              <i class="fas fa-edit"></i>
            </span>
          </td>
          <td>
            <span style="font-size: 16px; color: dimgrey;">
              <i class="fas fa-trash-alt"></i>
            </span>
          </td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>
</template>

<script>
  Vue.component("list-item-table", {
    template: "#list-item-table",
    vuetify: new Vuetify(),
    props: ['businessId'],
    data: () => ({}),
  });
</script>

<style>
  .table-small-column {
    width: 45px;
  }
</style>
