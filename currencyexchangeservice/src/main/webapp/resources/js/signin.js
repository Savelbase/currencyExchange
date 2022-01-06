document.getElementById("signInForm")
    .addEventListener("submit", (e) => {
        e.preventDefault();
        fetch("/api/v1/signin",
            {
                method: "POST",
                body: JSON.stringify({
                    login: document.getElementById("login").value,
                    password: document.getElementById("password").value
                })
            }).then(resp => {
            if(Math.floor(resp.status / 100) === 2) {
                alert("success");
                console.log(resp)
            } else {
                // may be some wrong
            }
        });
    });