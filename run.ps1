param(
  [switch] $Debug,
  [switch] $Cleanrun
)

$runargs = @(
  "spring-boot:run"
)
if($Debug){
  & .\mvnw $runargs > debug.log
}elseif($Cleanrun){
  $runargs = @(
    "clean"
    "spring-boot:run"
  )
  & .\mvnw $runargs 2>&1
} else{
  & .\mvnw $runargs 2>&1 
}





