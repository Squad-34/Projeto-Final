
/* COMANDO PARA DEIXAR A BARRA DE NAVEGAÇÃO COM OPACIDADE 
   BAIXA QUANDO ESTIVER FIXAR E COM COR SOLIDA AO MOVER A PAGINA */

window.addEventListener('scroll',
    function () {
        var navbar = document.getElementById('navbar');
        if (window.scrollY > 0) {
            navbar.classList.add('navbar-solido');
        } else {
            navbar.classList.remove('navbar-solido');
        }
    });
