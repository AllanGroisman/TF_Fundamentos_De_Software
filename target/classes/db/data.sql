INSERT INTO Produto (codigo,descricao,preco,qtd_min,qtd_max,qtd_atual)  VALUES 
   --buscaProdDispo() -- NÃO DEVE APARECER A
   (101,'A',10.0,50,100,49), --Limite inferior
   (102,'B',20.0,50,100,51), --Limite
   (103,'C',30.0,50,100,50), --Limite superior

   --Testar Descontos
   -- desconto de 30% se comprar 3x - Media vai comprar
   (104,'D',100000.0,0,100,50),
   --depois compra um desse - ValorTotal = 77
   (105,'E',100.0,0,100,50), 

   --desconto 25% se comprar 10x
   -- o 10x vai comprar 10x esse produto
   (106,'F',10.0,0,100,50),
   --depois comprar uma desse ValorTotal = 82,50
   (107,'G',10.0,0,100,50),

   --Nao da pra efetuar -- tenta pedir 10
   (108,'H',10.0,0,100,2);

