INSERT INTO produto (id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario)
VALUES (1, 'teclado', 'teclado bom', 'imagem teclado', '23/08/2021', '23/09/2021', 50.00 );
INSERT INTO produto (id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario)
VALUES (4, 'teclado', 'teclado bom', 'imagem teclado', '23/08/2021', '23/09/2021', 80.00 );
INSERT INTO produto (id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario)
VALUES (2, 'notbook', 'positivo o melhor dos melhores', 'imagem notebook', '20/08/2021', '20/09/2021', 2000.00 );
INSERT INTO produto (id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario)
VALUES (3, 'smartphone', 'xiaomi mi9 t pro', 'imagem xiaomi', '19/08/2021', '19/09/2021', 1999.99 );

INSERT INTO categoria (id, imagemSimboloUrl, nome, descricao)
VALUES (1, 'img1', 'Eletronico', 'temos categoria Eletronico');
INSERT INTO categoria (id, imagemSimboloUrl, nome, descricao)
VALUES (2, 'img2', 'Vestuario', 'temos categoria Vestuario');
INSERT INTO categoria (id, imagemSimboloUrl, nome, descricao)
VALUES (3, 'img3', 'Acessorios', 'temos categoria Acessorios');

INSERT INTO promocao (id, nome, descricao, dataInicio, dataFim, dataCadastro, dataUltimaAtualizacao)
VALUES (1, 'melhor promocao', '10% de desconto em alguns itens', '23/09/2021', '26/09/2021', '23/09/2021', '26/09/2021');

INSERT INTO promocao (id, nome, descricao, dataInicio, dataFim, dataCadastro, dataUltimaAtualizacao)
VALUES (2, 'Boa promoçao', 'quase tudo barato', '10/01/2021', '12/01/2021', '08/01/2021', '09/01/2021');

INSERT INTO categoriaProduto (id, categoriaId, produtoId)
VALUES (1, 3, 1);
INSERT INTO categoriaProduto (id, categoriaId, produtoId)
VALUES (5, 3, 4);

INSERT INTO categoriaProduto (id, categoriaId, produtoId)
VALUES (2, 1, 2);

INSERT INTO promocaoItem (id, valorPromocao, dataCadastro, dataUltimaAtualizacao, produtoId, promocaoId)
VALUES (9, 45.00, '24/09/2021', '25/09/2021', 1, 1);

INSERT INTO promocaoItem (id, valorPromocao, dataCadastro, dataUltimaAtualizacao, produtoId, promocaoId)
VALUES (7, 1900.00, '24/09/2021', '25/09/2021', 3, 2);







