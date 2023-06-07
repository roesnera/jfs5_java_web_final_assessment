async function fetchHeroes() {
    const data = await fetch("http://localhost:8080/api/v1/heroes");
    // console.log(data);
    const dataJson = await data.json();
    const heroesSection = document.getElementById("heroesSection");
    heroesSection.innerHTML = "";
    // console.log(dataJson);
    for(const hero of dataJson){
        const el = document.createElement("div");
        console.log(hero);
        el.innerHTML = "------------------<br/>";
        for(const property in hero) {
            console.log(property);
            el.innerHTML += `${property} of this hero is: ${hero[property]}<br/>`;
        }
        el.innerHTML += "------------------<br/>";
        heroesSection.appendChild(el);
    }
}

fetchHeroes();

async function postHero(event) {
    event.preventDefault();
    const heroName = document.getElementById("heroName");
    const heroPower = document.getElementById("heroPower");

    const name = heroName.value;
    const power = heroPower.value;

    const heroDto = {
        name,
        power
    }

    const initialRequestObj = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(heroDto)
    }

    await fetch("http://localhost:8080/api/v1/heroes", initialRequestObj);

    await fetchHeroes();

}

const form = document.getElementById("heroPostForm");
form.addEventListener("submit", postHero)