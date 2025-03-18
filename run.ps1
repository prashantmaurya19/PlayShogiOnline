param(
  [switch] $Debug
)

$runargs = @(
  "spring-boot:run"
)
if(-Not $Debug){
  & .\mvnw $runargs 2>&1
}else{
  & .\mvnw $runargs > debug.log
}





