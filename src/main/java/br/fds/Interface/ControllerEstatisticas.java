// package br.fds.Interface;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.fds.Aplicacao.Estatistica.Estatistica1_UC;
// import br.fds.Aplicacao.Estatistica.Estatistica2_UC;
// import br.fds.Aplicacao.Estatistica.Estatistica3_UC;

// @RestController
// @RequestMapping("/estatistica")
// public class ControllerEstatisticas {
//     private Estatistica1_UC estatistica1_UC;
//     private Estatistica2_UC estatistica2_UC;
//     private Estatistica3_UC estatistica3_UC;

//     // Construtor
//     @Autowired
//     public ControllerEstatisticas(Estatistica1_UC estatistica1_UC, Estatistica2_UC estatistica2_UC,
//             Estatistica3_UC estatistica3_UC) {
//         this.estatistica1_UC = estatistica1_UC;
//         this.estatistica2_UC = estatistica2_UC;
//         this.estatistica3_UC = estatistica3_UC;
//          System.out.println("\n\nCriado Controller Serviços\n\n");
     
//}
    // //Entrada padrão
    // @GetMapping("/")
    // @CrossOrigin(origins = "*")
    // public String inicioServicos() {
    //     return "Estatisticas do Sistema";
    // }





//     // Chamar estatistica 1
//     @GetMapping("/estatistica1")
//     @CrossOrigin("*")
//     public int estatistica1() {
//         return 1;
//     }

//     // Chamar estatistica 2
//     @GetMapping("/estatistica2")
//     @CrossOrigin("*")
//     public int estatistica2() {
//         return 2;
//     }

//     // Chamar estatistica 3
//     @GetMapping("/estatistica3")
//     @CrossOrigin("*")
//     public int estatistica3() {
//         return 3;
//     }
// }
