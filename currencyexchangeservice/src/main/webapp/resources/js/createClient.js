document.getElementById("newClient")
    .addEventListener("submit", (e) => {
        e.preventDefault();
        fetch("/api/v1/login",
            {
                method: "POST",
                body: JSON.stringify({
                    login: document.getElementById("login").value,
                    password: document.getElementById("password").value
                })
            }).then(resp => {
            if(Math.floor(resp.status / 100) === 2) {
                alert("success");
            } else {
                // may be some wrong
            }
        });
    });
