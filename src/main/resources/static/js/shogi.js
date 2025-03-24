// const boardElement = document.querySelector("#shogi-board");
// const capturedPlayer1 = document.querySelector("#captured-pieces-player1");
// const capturedPlayer2 = document.querySelector("#captured-pieces-player2");
function initGame() {
  gameState = {
    board: [
      ["l1", "n1", "s1", "g1", "k", "g2", "s2", "n2", "l2"],
      [null, "r1", null, null, null, null, null, "b2", null],
      ["p1", "p1", "p1", "p1", "p1", "p1", "p1", "p1", "p1"],
      [null, null, null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, null, null],
      ["p2", "p2", "p2", "p2", "p2", "p2", "p2", "p2", "p2"],
      [null, "b1", null, null, null, null, null, "r2", null],
      ["l2", "n2", "s2", "g2", "k2", "g1", "s1", "n1", "l1"],
    ],
    captured: { player1: [], player2: [] },
    turn: 1,
    selectedPiece: null,
    possibleMoves: [],
  };
  renderBoard();
}

function renderBoard() {
  boardElement.innerHTML = "";
  gameState.board.forEach((row, rowIndex) => {
    row.forEach((piece, colIndex) => {
      const square = document.createElement("div");
      square.classList.add("square");
      square.dataset.row = rowIndex;
      square.dataset.col = colIndex;
      if (piece) {
        square.textContent = piece; //visual of the piece. Change this to images/unicode.
        square.addEventListener("click", () =>
          handlePieceClick(rowIndex, colIndex),
        );
      } else {
        square.addEventListener("click", () =>
          handleSquareClick(rowIndex, colIndex),
        );
      }
      boardElement.appendChild(square);
    });
  });
  renderCapturedPieces();
}

function renderCapturedPieces() {
  capturedPlayer1.innerHTML =
    "Captured P1: " + gameState.captured.player1.join(", ");
  capturedPlayer2.innerHTML =
    "Captured P2: " + gameState.captured.player2.join(", ");
}

function handlePieceClick(row, col) {
  const piece = gameState.board[row][col];
  if (
    (gameState.turn === 1 && piece.endsWith("1")) ||
    (gameState.turn === 2 && piece.endsWith("2"))
  ) {
    gameState.selectedPiece = { row, col };
    gameState.possibleMoves = getPossibleMoves(row, col);
    renderBoard();
    highlightPossibleMoves();
  }
}

function handleSquareClick(row, col) {
  if (
    gameState.possibleMoves.some((move) => move.row === row && move.col === col)
  ) {
    makeMove(
      gameState.selectedPiece.row,
      gameState.selectedPiece.col,
      row,
      col,
    );
  }
}

function highlightPossibleMoves() {
  gameState.possibleMoves.forEach((move) => {
    const square = document.querySelector(
      `.square[data-row="${move.row}"][data-col="${move.col}"]`,
    );
    square.style.backgroundColor = "lightblue";
  });
}

function makeMove(fromRow, fromCol, toRow, toCol) {
  const piece = gameState.board[fromRow][fromCol];
  if (gameState.board[toRow][toCol]) {
    capturePiece(gameState.board[toRow][toCol]);
  }
  gameState.board[toRow][toCol] = piece;
  gameState.board[fromRow][fromCol] = null;
  gameState.selectedPiece = null;
  gameState.possibleMoves = [];
  gameState.turn = 3 - gameState.turn;
  renderBoard();
  if (isCheckmate(gameState.turn)) {
    alert("Checkmate!");
  }
}

function capturePiece(piece) {
  if (gameState.turn === 1) {
    gameState.captured.player1.push(piece);
  } else {
    gameState.captured.player2.push(piece);
  }
}

function getPossibleMoves(row, col) {
  //Implement all piece movement rules here.
  const piece = gameState.board[row][col];
  let moves = [];
  //Example movement for pawn
  if (piece.startsWith("p")) {
    const direction = piece.endsWith("1") ? -1 : 1;
    if (
      row + direction >= 0 &&
      row + direction < 9 &&
      !gameState.board[row + direction][col]
    ) {
      moves.push({ row: row + direction, col });
    }
    //Add capturing for pawns.
  }
  //Add movements for other pieces.
  return moves;
}

function isCheckmate(player) {
  //Implement checkmate detection here.
  return false; //Placeholder
}
