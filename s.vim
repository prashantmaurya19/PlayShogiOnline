let SessionLoad = 1
let s:so_save = &g:so | let s:siso_save = &g:siso | setg so=0 siso=0 | setl so=-1 siso=-1
let v:this_session=expand("<sfile>:p")
silent only
silent tabonly
cd ~/Documents/Prashant/Java/PSO
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
let s:shortmess_save = &shortmess
if &shortmess =~ 'A'
  set shortmess=aoOA
else
  set shortmess=aoO
endif
badd +23 src/main/java/com/prashantMaurya/PSO/Configuration/SecurityConfig.java
badd +15 src/main/resources/templates/login.html
badd +6 src/main/resources/templates/index.html
badd +17 src/main/java/com/prashantMaurya/PSO/Controllers/PublicRoute.java
badd +31 src/main/java/com/prashantMaurya/PSO/Controllers/RegisterRoute.java
badd +15 src/main/java/com/prashantMaurya/PSO/Configuration/RouteConfig.java
badd +37 src/main/java/com/prashantMaurya/PSO/Controllers/UserRoute.java
badd +13 src/main/resources/templates/dashboard.html
badd +23 src/main/resources/templates/register.html
badd +11 src/main/java/com/prashantMaurya/PSO/Pojo/RegisterResponse.java
badd +75 src/main/java/com/prashantMaurya/PSO/Services/UserService.java
badd +9 src/main/java/com/prashantMaurya/PSO/Controllers/AuthController.java
badd +1 target/classes/templates/register.html
badd +9 src/main/java/com/prashantMaurya/PSO/Controllers/IndexRoute.java
badd +1 src/main/java/com/prashantMaurya/PSO/Controllers/ViewRoute.java
badd +5 src/main/resources/static/style.css
badd +2 target/classes/static/jquery.min.js
badd +2 target/classes/static/bootstrap.min.js
badd +2 target/classes/static/popper.js
badd +1 target/classes/static/main.js
badd +1 src/main/resources/static/
argglobal
%argdel
set stal=2
tabnew +setlocal\ bufhidden=wipe
tabnew +setlocal\ bufhidden=wipe
tabnew +setlocal\ bufhidden=wipe
tabnew +setlocal\ bufhidden=wipe
tabnew +setlocal\ bufhidden=wipe
tabrewind
edit src/main/java/com/prashantMaurya/PSO/Configuration/SecurityConfig.java
argglobal
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 23 - ((12 * winheight(0) + 19) / 38)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 23
normal! 037|
lcd ~/Documents/Prashant/Java/PSO
tabnext
edit ~/Documents/Prashant/Java/PSO/src/main/resources/templates/login.html
argglobal
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 15 - ((14 * winheight(0) + 19) / 38)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 15
normal! 06|
lcd ~/Documents/Prashant/Java/PSO
tabnext
edit ~/Documents/Prashant/Java/PSO/src/main/resources/templates/register.html
argglobal
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 18 - ((17 * winheight(0) + 19) / 38)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 18
normal! 031|
lcd ~/Documents/Prashant/Java/PSO
tabnext
edit ~/Documents/Prashant/Java/PSO/src/main/java/com/prashantMaurya/PSO/Controllers/RegisterRoute.java
argglobal
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 34 - ((33 * winheight(0) + 19) / 38)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 34
normal! 066|
lcd ~/Documents/Prashant/Java/PSO
tabnext
edit ~/Documents/Prashant/Java/PSO/src/main/java/com/prashantMaurya/PSO/Controllers/ViewRoute.java
argglobal
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 4 - ((3 * winheight(0) + 19) / 38)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 4
normal! 02|
lcd ~/Documents/Prashant/Java/PSO
tabnext
edit ~/Documents/Prashant/Java/PSO/src/main/java/com/prashantMaurya/PSO/Services/UserService.java
argglobal
balt ~/Documents/Prashant/Java/PSO/src/main/java/com/prashantMaurya/PSO/Pojo/RegisterResponse.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 75 - ((17 * winheight(0) + 19) / 38)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 75
normal! 020|
lcd ~/Documents/Prashant/Java/PSO
tabnext 2
set stal=1
if exists('s:wipebuf') && len(win_findbuf(s:wipebuf)) == 0 && getbufvar(s:wipebuf, '&buftype') isnot# 'terminal'
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20
let &shortmess = s:shortmess_save
let s:sx = expand("<sfile>:p:r")."x.vim"
if filereadable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &g:so = s:so_save | let &g:siso = s:siso_save
set hlsearch
nohlsearch
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
