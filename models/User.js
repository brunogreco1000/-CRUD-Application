const usersCollection = require('../db').collection('whiterevolution88')
const validator = require('validator')

let User = function(data) {
    this.data = data
    this.errors = []
}

User.prototype.cleanUp = function() {
    if (typeof(this.data.username) != "string") {this.data.username = ""}
    if (typeof(this.data.email) != "string") {this.data.email = ""}
    if (typeof(this.data.password) != "string") {this.data.password = ""}

    this.data = {
        username: this.data.username.trim().toLowerCase(),
        email: this.data.email.trim(),
        password: this.data.password
    }
}


User.prototype.validate = function() {
    if (this.data.username == "") {this.errors.push("You must provide a username.")}
    if (this.data.username != "" && !validator.isAlphanumeric(this.data.username)) {this.errors.push("Username can only contain letters and numbers.")}
    if (!validator.isEmail(this.data.email)) {this.errors.push("You must provide a valid email address.")}
    if (this.data.email == "") {this.errors.push("You must provide a valid email address")}
    if (this.data.password == "") {this.errors.push("You must provide a password.")}
    if (this.data.username.length > 0 && this.data.username.length < 3) {this.errors.push("Username must be at least 3 characters.")}
    if (this.data.username.length > 30) {this.errors.push("Username cannot exceed 30 characters.")}
}

User.prototype.login = function(callback) {
    this.cleanUp()
    usersCollection.findOne({username: this.data.username}, (err, attemptedUser) => {
     if (attemptedUser && attemptedUser.password == this.data.password) {
        callback("Congrats!")
     }  else {
        callback("Invalid username / password.")
     } 
    })
}

User.prototype.register = function() {
    this.cleanUp()
    this.validate()
    if (!this.errors.length) {
        usersCollection.insertOne(this.data)
    }
}

module.exports = User