<script>
import axios from 'axios'

export default {
  data() {
    return {
      users: null,
      id: null,
      name: '',
      email: '',
      password: '',
      status: false,
      cadastrar: true
    }
  },
  
  mounted() {
    //listar todos
    axios
      .get("http://localhost:8080/user/")
      .then((response) => {
          this.users = response.data
        })
      .catch((error) => {
        console.error(error);
      });
      
  },
  methods: {
    //pegar um pelo id
    getUser(id) {
      axios
       .get(`http://localhost:8080/user/${id}`)
       .then((response) => {
          this.id = response.data.id;
          this.name = response.data.name;
          this.email = response.data.email;
          this.password = response.data.password;
          this.status = response.data.status;
        })
       .catch((error) => {
          console.error(error);
        });
        this.cadastrar = false
    },
    //deleta pelo id
    deleteUser(id) {
      axios
       .delete(`http://localhost:8080/user/${id}`)
       .then((response) => {
          console.log(response.data);
          this.users = this.users.filter((user) => user.id!== id);
        })
       .catch((error) => {
          console.error(error);
        });
    },
    //cadastra novo
    createUser(e){
      e.preventDefault();
      const user = {
        name: this.name,
        email: this.email,
        password: this.password,
        status: this.status
      }
      axios
       .post("http://localhost:8080/user/", user)
       .then((response) => {
          console.log(response.data);
          this.users.push(response.data);
        })
       .catch((error) => {
          console.error("Deu erro "+error);
        });
    },
    //atualiza pelo id
    updateUser(id, e){
      e.preventDefault();     
      const user = {
        id: id,
        name: this.name,
        email: this.email,
        password: this.password,
        status: this.status
      }
      axios
       .put(`http://localhost:8080/user/${id}`, user)
       .then((response) => {
          console.log(response.data);
          const index = this.users.findIndex((user) => user.id === id);
          this.users[index] = response.data;
        })
       .catch((error) => {
          console.error("Deu erro "+error);
        });
    }
  }
}

</script>

<template>
  <header>

  </header>
  <main>  
    <table>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Status</th>
        <th>Deletar</th>
        <th>Editar</th>
      </tr>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.name }}</td>
        <td>{{ user.email }}</td>
        <td>{{ user.status }}</td>
        <td><button @click="deleteUser(user.id)">🗑️</button></td>
        <td><button @click="getUser(user.id)">✏️</button></td>
      </tr>
    </table>

    <h2>{{ cadastrar ? "Adicionar Novo " : "Atualizar" }}  Usuário</h2>
    <form>
      
      <div>
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" v-model="name" required>
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" v-model="email" required>
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" v-model="password" required>
      </div>
      <div>
        <input type="checkbox" id="status" v-model="status" />
        <label for="checkbox">{{ status ? " Ativo" : " Inativo" }}</label>
      </div>
      <div>     
        <button v-if="cadastrar" @click="createUser" type="submit">Adicionar</button>
        <button v-else @click="updateUser(id, $event)" type="submit">Atualizar</button>
      </div>

    </form>

  </main>
</template>

<style scoped>
table, th, td {
  border: 1px solid black;
}
</style>
