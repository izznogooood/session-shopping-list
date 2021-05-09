<!--suppress ALL -->
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
            v-for="item in $javalin.state.businesses[businessId].shoppingList"
            :key="item.id"
        >
          <td>{{ item.quantity }}</td>
          <td class="text-left">{{ item.name }}</td>
          <td>
            <span @click="editItem(item.id)" style="font-size: 16px; color: dimgrey;  cursor: pointer">
              <i class="fas fa-edit"></i>
            </span>
          </td>
          <td>
            <span @click="removeItem(item.id)" style="font-size: 16px; color: dimgrey; cursor: pointer">
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
    methods: {
      editItem(id) {
        console.log(id)
      },
      removeItem(id) {
        console.log(id)
      }
    }
  });
</script>

<style>
  .table-small-column {
    width: 45px;
  }
</style>
