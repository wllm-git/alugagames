
INSERT INTO `cliente` (`id`, `cidade`, `cpf`, `dataNascimento`, `email`, `nome`, `rg`, `senha`, `sexo`, `telefone`, `uf`) VALUES
(0x84f30441a0bf492995d8b4575f7e8b12, 'Recife', '84352747300', '1986-09-01 00:00:00', 'douglas@gmail.com', 'Douglas Fonseca de Oliveira', '992003984', 'Šöœ9~H[+À£ý…å„]', 'M', '81992003994', 'PE'),
(0x9716bfb7d4b44f14b4078fba95805801, 'João Pessoa', '51122321880', '1991-03-29 00:00:00', 'daniel@gmail.com', 'Daniel Rodrigues', '0039940', 'Šöœ9~H[+À£ý…å„]', 'M', '99209399402', 'PB'),
(0xb58b92bb891e448a91213198e480f9de, 'Recife', '08960677426', '1993-11-20 00:00:00', 'roldao.wilker@gmail.com', 'Roldão Wilker Bélo de Araújo', '8333594', 'Šöœ9~H[+À£ý…å„]', 'M', '81998827364', 'PE');





INSERT INTO `funcionario` (`id`, `ativo`, `cpf`, `dataNascimento`, `email`, `funcao`, `nome`, `senha`, `sexo`, `telefone`) VALUES
(0x0a4d1333782142eba0ec1421107a7b74, 0, '33684945897', '1986-11-18 00:00:00', 'atendente@alugagames.com.br', 'Atendente', 'Atendente', 'Šöœ9~H[+À£ý…å„]', 'F', '90299930049'),
(0x3b9e63600cdf495cb7b2cf643e351baf, 0, '48456469866', '1991-11-24 00:00:00', 'tecnico@alugagames.com.br', 'Tecnico', 'Tecnico', 'Šöœ9~H[+À£ý…å„]', 'M', '91888277378'),
(0x73ff6c9db14142edbd8ffb9a52d6f578, 0, '65567217862', '1987-11-16 00:00:00', 'gerente@alugagames.com.br', 'Gerente', 'Gerente', 'Šöœ9~H[+À£ý…å„]', 'M', '99920993848');



INSERT INTO `jogo` (`id`, `anoLancamento`, `categoria`, `nome`) VALUES
(0x304aaffb09ec49c8ab0607120c3b8a36, '2016', 2, 'Fifa 2017'),
(0x3df46bfe8de1426eba80fa0390276b7f, '2009', 0, 'Grand Theft Auto San Andreas'),
(0x56ef9f0f37494c1aa288ebee940ffb40, '2011', 4, 'Mario Bros'),
(0x6ea5c628d3c84279ba4c565b95c8f7e7, '2011', 1, 'Duke Nuke 3D'),
(0x75f8ae91ffd94121b596b0b1115ba7b8, '2013', 0, 'Grand Theft Auto VI'),
(0x778c9541df794d7cbdacab533398b253, '2015', 2, 'Fifa 2016'),
(0x82ff928f0c1842f59926aac94115b053, '2003', 3, 'Need For Speed Underground II'),
(0x9c991d0adc6c47e19a30dce6ae5d8e2f, '2015', 2, 'Pro Evolution Soccer 2016'),
(0xab7811f48ec64884b7dcb3e0193937e4, '2011', 1, 'Call of Duty - Modern Fire'),
(0xe54918bfc03946cba6384f8e412026db, '2008', 3, 'Need For Speed Most Wanted'),
(0xee768212ef7747dca7ce6d6e697a81b6, '2014', 2, 'Pro Evolution Soccer 2015');






INSERT INTO `tipoconsole` (`id`, `ativo`, `nome`) VALUES
(0x1dd9438cb3734d85b92a1712e034e677, 1, 'Xbox One'),
(0x2572b057b62542bb98c2c02ad1de2a94, 1, 'Nitendo WII'),
(0x5ae3e68c2a5a4c3588b19b2d28f2cc6b, 1, 'PS4'),
(0xeeb49680c1924b62ab690b4e60131895, 1, 'Xbox 360');


INSERT INTO `midia` (`id`, `ativo`, `numeroSerie`, `status`, `preco`, `jogo_id`, `tipoconsole_id`) VALUES
(0x013ef5d39dd54ec4bec0d5de6d674168, 1, 'FIFA992004', 'Disponivel', 12, 0x304aaffb09ec49c8ab0607120c3b8a36, 0x5ae3e68c2a5a4c3588b19b2d28f2cc6b),
(0x214130cffc3c4437ba87c2df1a721b82, 1, 'GTA2001923', 'Disponivel', 15, 0x3df46bfe8de1426eba80fa0390276b7f, 0x1dd9438cb3734d85b92a1712e034e677),
(0x35d8a2284ad64437b9a023c20dcf0cb0, 1, 'FIFA992003', 'Disponivel', 12, 0x304aaffb09ec49c8ab0607120c3b8a36, 0x1dd9438cb3734d85b92a1712e034e677),
(0x7e450bf21b814a3f9885f11393cc4581, 1, 'GTA2001928', 'Disponivel', 16, 0x3df46bfe8de1426eba80fa0390276b7f, 0x2572b057b62542bb98c2c02ad1de2a94),
(0xb1f05529405c4581a03a6d27899c8754, 1, 'MB122112', 'Disponivel', 12, 0x56ef9f0f37494c1aa288ebee940ffb40, 0x2572b057b62542bb98c2c02ad1de2a94),
(0xd7ff7992a7484c4797df32927099918b, 1, 'GTA2001926', 'Disponivel', 15, 0x3df46bfe8de1426eba80fa0390276b7f, 0x5ae3e68c2a5a4c3588b19b2d28f2cc6b);




