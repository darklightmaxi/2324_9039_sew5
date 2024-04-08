#!/bin/bash
set -e
mkdir /home
getent passwd maximilian_de_junious > /dev/null && echo 'User maximilian_de_junious already exists. Aborting.' && exit 1 || true
groupadd de_junious
useradd -d /home/de_junious -c de_junious -m -g de_junious -G student,2CN -s /bin/bash maximilian_de_junious
echo maximilian_de_junious:1pKT=TZ#qJ;m | chpasswd
getent passwd ramon_nunez_gomez > /dev/null && echo 'User ramon_nunez_gomez already exists. Aborting.' && exit 1 || true
groupadd nunez_gomez
useradd -d /home/nunez_gomez -c nunez_gomez -m -g nunez_gomez -G student,3BN -s /bin/bash ramon_nunez_gomez
echo ramon_nunez_gomez:;V*^[]C#5\'ke | chpasswd
getent passwd ulku_omer_ullagoss > /dev/null && echo 'User ulku_omer_ullagoss already exists. Aborting.' && exit 1 || true
groupadd ullagoss
useradd -d /home/ullagoss -c ullagoss -m -g ullagoss -G student,1AN -s /bin/bash ulku_omer_ullagoss
echo ulku_omer_ullagoss:Y^s\`IeN\'K-BS | chpasswd
getent passwd isis_lanpher > /dev/null && echo 'User isis_lanpher already exists. Aborting.' && exit 1 || true
groupadd lanpher
useradd -d /home/lanpher -c lanpher -m -g lanpher -G student,4CN -s /bin/bash isis_lanpher
echo isis_lanpher:7\`)U{-]oS@HW | chpasswd
getent passwd maximilian_galvin > /dev/null && echo 'User maximilian_galvin already exists. Aborting.' && exit 1 || true
groupadd galvin
useradd -d /home/galvin -c galvin -m -g galvin -G student,2AN -s /bin/bash maximilian_galvin
echo maximilian_galvin:HvVA.E9l_HL+ | chpasswd
getent passwd jannette_laspina > /dev/null && echo 'User jannette_laspina already exists. Aborting.' && exit 1 || true
groupadd laspina
useradd -d /home/laspina -c laspina -m -g laspina -G student,4CN -s /bin/bash jannette_laspina
echo jannette_laspina:(;RpVoJoh\hD | chpasswd
getent passwd marg_dodich > /dev/null && echo 'User marg_dodich already exists. Aborting.' && exit 1 || true
groupadd dodich
useradd -d /home/dodich -c dodich -m -g dodich -G student,3CN -s /bin/bash marg_dodich
echo marg_dodich:V#d/+$]d#Zz! | chpasswd
getent passwd carisa_bannowsky > /dev/null && echo 'User carisa_bannowsky already exists. Aborting.' && exit 1 || true
groupadd bannowsky
useradd -d /home/bannowsky -c bannowsky -m -g bannowsky -G student,2AN -s /bin/bash carisa_bannowsky
echo carisa_bannowsky:&}Xipcc@\6zD | chpasswd
getent passwd david_waisath > /dev/null && echo 'User david_waisath already exists. Aborting.' && exit 1 || true
groupadd waisath
useradd -d /home/waisath -c waisath -m -g waisath -G student,4CN -s /bin/bash david_waisath
echo david_waisath:#A9=fr$\"h&zu | chpasswd
getent passwd paulette_von_reddigpiette > /dev/null && echo 'User paulette_von_reddigpiette already exists. Aborting.' && exit 1 || true
groupadd von_reddigpiette
useradd -d /home/von_reddigpiette -c von_reddigpiette -m -g von_reddigpiette -G student,2CN -s /bin/bash paulette_von_reddigpiette
echo paulette_von_reddigpiette:h,\"[^N2\'7yHG | chpasswd
getent passwd kirby_latona > /dev/null && echo 'User kirby_latona already exists. Aborting.' && exit 1 || true
groupadd latona
useradd -d /home/latona -c latona -m -g latona -G student,2AN -s /bin/bash kirby_latona
echo kirby_latona:es)Ep+|bkxGA | chpasswd
getent passwd reed_homewood > /dev/null && echo 'User reed_homewood already exists. Aborting.' && exit 1 || true
groupadd homewood
useradd -d /home/homewood -c homewood -m -g homewood -G student,2BN -s /bin/bash reed_homewood
echo reed_homewood:Gw)s_)M\'Z6a\ | chpasswd
getent passwd blair_pallaforzedian > /dev/null && echo 'User blair_pallaforzedian already exists. Aborting.' && exit 1 || true
groupadd pallaforzedian
useradd -d /home/pallaforzedian -c pallaforzedian -m -g pallaforzedian -G student,5CN -s /bin/bash blair_pallaforzedian
echo blair_pallaforzedian:iG[Xy-l*NB\'B | chpasswd
getent passwd lon_senemounnaratquillian > /dev/null && echo 'User lon_senemounnaratquillian already exists. Aborting.' && exit 1 || true
groupadd senemounnaratquillian
useradd -d /home/senemounnaratquillian -c senemounnaratquillian -m -g senemounnaratquillian -G student,2CN -s /bin/bash lon_senemounnaratquillian
echo lon_senemounnaratquillian:\`-Fc];Q8<Gt0 | chpasswd
getent passwd vada_isaac > /dev/null && echo 'User vada_isaac already exists. Aborting.' && exit 1 || true
groupadd isaac
useradd -d /home/isaac -c isaac -m -g isaac -G student,2BN -s /bin/bash vada_isaac
echo vada_isaac:}46KSvS)2OFG | chpasswd
getent passwd jeanett_plancarte > /dev/null && echo 'User jeanett_plancarte already exists. Aborting.' && exit 1 || true
groupadd plancarte
useradd -d /home/plancarte -c plancarte -m -g plancarte -G student,4BN -s /bin/bash jeanett_plancarte
echo jeanett_plancarte:IOqcz|YHO@R\" | chpasswd
getent passwd alex_berteottistirn > /dev/null && echo 'User alex_berteottistirn already exists. Aborting.' && exit 1 || true
groupadd berteottistirn
useradd -d /home/berteottistirn -c berteottistirn -m -g berteottistirn -G teacher,None -s /bin/bash alex_berteottistirn
echo alex_berteottistirn:|J=t<V7]F<\M | chpasswd
getent passwd robyn_strycker > /dev/null && echo 'User robyn_strycker already exists. Aborting.' && exit 1 || true
groupadd strycker
useradd -d /home/strycker -c strycker -m -g strycker -G student,3AN -s /bin/bash robyn_strycker
echo robyn_strycker:PT:H_1AoKM#m | chpasswd
getent passwd camille_von_verrill > /dev/null && echo 'User camille_von_verrill already exists. Aborting.' && exit 1 || true
groupadd von_verrill
useradd -d /home/von_verrill -c von_verrill -m -g von_verrill -G student,3BN -s /bin/bash camille_von_verrill
echo camille_von_verrill:{@!c)nasOvQ4 | chpasswd
getent passwd franz_michael_leopold_deschner > /dev/null && echo 'User franz_michael_leopold_deschner already exists. Aborting.' && exit 1 || true
groupadd deschner
useradd -d /home/deschner -c deschner -m -g deschner -G student,4CN -s /bin/bash franz_michael_leopold_deschner
echo franz_michael_leopold_deschner:gd]z&M^*!z$7 | chpasswd
getent passwd veola_franzi > /dev/null && echo 'User veola_franzi already exists. Aborting.' && exit 1 || true
groupadd franzi
useradd -d /home/franzi -c franzi -m -g franzi -G teacher,None -s /bin/bash veola_franzi
echo veola_franzi:.$m,5FH19#(d | chpasswd
getent passwd chantelle_cringle > /dev/null && echo 'User chantelle_cringle already exists. Aborting.' && exit 1 || true
groupadd cringle
useradd -d /home/cringle -c cringle -m -g cringle -G student,3CN -s /bin/bash chantelle_cringle
echo chantelle_cringle:%,YKcKln)8uI | chpasswd
getent passwd britney_kosh > /dev/null && echo 'User britney_kosh already exists. Aborting.' && exit 1 || true
groupadd kosh
useradd -d /home/kosh -c kosh -m -g kosh -G student,5BN -s /bin/bash britney_kosh
echo britney_kosh:}t<9LT\'R$[xq | chpasswd
getent passwd clayton_derouchie > /dev/null && echo 'User clayton_derouchie already exists. Aborting.' && exit 1 || true
groupadd derouchie
useradd -d /home/derouchie -c derouchie -m -g derouchie -G student,4BN -s /bin/bash clayton_derouchie
echo clayton_derouchie:%uT#h+vWu<)d | chpasswd
getent passwd beverlee_doutt > /dev/null && echo 'User beverlee_doutt already exists. Aborting.' && exit 1 || true
groupadd doutt
useradd -d /home/doutt -c doutt -m -g doutt -G student,5BN -s /bin/bash beverlee_doutt
echo beverlee_doutt:ERd-5&x8_d\'\` | chpasswd
getent passwd alma_munley > /dev/null && echo 'User alma_munley already exists. Aborting.' && exit 1 || true
groupadd munley
useradd -d /home/munley -c munley -m -g munley -G student,1BN -s /bin/bash alma_munley
echo alma_munley:v/\{k%?Hx\`F_ | chpasswd
getent passwd thad_dornbos > /dev/null && echo 'User thad_dornbos already exists. Aborting.' && exit 1 || true
groupadd dornbos
useradd -d /home/dornbos -c dornbos -m -g dornbos -G student,5AN -s /bin/bash thad_dornbos
echo thad_dornbos:m|x9qMR\'#GE< | chpasswd
getent passwd arvilla_mahala > /dev/null && echo 'User arvilla_mahala already exists. Aborting.' && exit 1 || true
groupadd mahala
useradd -d /home/mahala -c mahala -m -g mahala -G student,2CN -s /bin/bash arvilla_mahala
echo arvilla_mahala:TIQa6fpWQAF8 | chpasswd
getent passwd mirza_ellingwood > /dev/null && echo 'User mirza_ellingwood already exists. Aborting.' && exit 1 || true
groupadd ellingwood
useradd -d /home/ellingwood -c ellingwood -m -g ellingwood -G teacher,None -s /bin/bash mirza_ellingwood
echo mirza_ellingwood:N|z&x5dxV6:h | chpasswd
getent passwd francie_de_cardinallisciola > /dev/null && echo 'User francie_de_cardinallisciola already exists. Aborting.' && exit 1 || true
groupadd de_cardinallisciola
useradd -d /home/de_cardinallisciola -c de_cardinallisciola -m -g de_cardinallisciola -G student,3AN -s /bin/bash francie_de_cardinallisciola
echo francie_de_cardinallisciola:X&Q%D~~W;oXr | chpasswd
getent passwd irenee_gundry > /dev/null && echo 'User irenee_gundry already exists. Aborting.' && exit 1 || true
groupadd gundry
useradd -d /home/gundry -c gundry -m -g gundry -G teacher,None -s /bin/bash irenee_gundry
echo irenee_gundry:q+Fnfw}0{VE. | chpasswd
getent passwd irenee_pinedo > /dev/null && echo 'User irenee_pinedo already exists. Aborting.' && exit 1 || true
groupadd pinedo
useradd -d /home/pinedo -c pinedo -m -g pinedo -G student,3CN -s /bin/bash irenee_pinedo
echo irenee_pinedo:?T=Zdu:\"yyHq | chpasswd
getent passwd chelah_faivre > /dev/null && echo 'User chelah_faivre already exists. Aborting.' && exit 1 || true
groupadd faivre
useradd -d /home/faivre -c faivre -m -g faivre -G student,2CN -s /bin/bash chelah_faivre
echo chelah_faivre:}pG;ChYOK\`rX | chpasswd
getent passwd mirza_pinsky > /dev/null && echo 'User mirza_pinsky already exists. Aborting.' && exit 1 || true
groupadd pinsky
useradd -d /home/pinsky -c pinsky -m -g pinsky -G student,1BN -s /bin/bash mirza_pinsky
echo mirza_pinsky:h^$X#\h(jf7} | chpasswd
getent passwd francie_pinsky1 > /dev/null && echo 'User francie_pinsky1 already exists. Aborting.' && exit 1 || true
groupadd pinsky1
useradd -d /home/pinsky1 -c pinsky1 -m -g pinsky1 -G student,1BN -s /bin/bash francie_pinsky1
echo francie_pinsky1:-z/|aN[Xt,=| | chpasswd
getent passwd goldie_pinsky2 > /dev/null && echo 'User goldie_pinsky2 already exists. Aborting.' && exit 1 || true
groupadd pinsky2
useradd -d /home/pinsky2 -c pinsky2 -m -g pinsky2 -G student,1BN -s /bin/bash goldie_pinsky2
echo goldie_pinsky2:n/VZev1w\`d2s | chpasswd
getent passwd another_pinsky3 > /dev/null && echo 'User another_pinsky3 already exists. Aborting.' && exit 1 || true
groupadd pinsky3
useradd -d /home/pinsky3 -c pinsky3 -m -g pinsky3 -G student,1BN -s /bin/bash another_pinsky3
echo another_pinsky3:jd8lp%VE\`Ce+ | chpasswd
getent passwd andromede_norlien > /dev/null && echo 'User andromede_norlien already exists. Aborting.' && exit 1 || true
groupadd norlien
useradd -d /home/norlien -c norlien -m -g norlien -G student,2AN -s /bin/bash andromede_norlien
echo andromede_norlien:YL\`=+tX!Jp?t | chpasswd
getent passwd helaah_preato > /dev/null && echo 'User helaah_preato already exists. Aborting.' && exit 1 || true
groupadd preato
useradd -d /home/preato -c preato -m -g preato -G student,1BN -s /bin/bash helaah_preato
echo helaah_preato:Z913M\`nX<A1? | chpasswd
