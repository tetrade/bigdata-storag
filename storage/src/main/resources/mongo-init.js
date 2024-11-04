db.createUser({
    user: "rootuser",
    pwd: "rootpassword",
    roles: [{
        role: "readWrite",
        db: "mydatabase"
    }]
});