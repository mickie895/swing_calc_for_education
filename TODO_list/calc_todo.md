# 電卓アプリのToDoリスト

## 優先するToDo

## 後回し

* [ ] KeyオブジェクトのGetValueがオブジェクト指向エクササイズの原則を逸脱している
  * [ ] 結果を数値ではなく文字で返す？
* [ ] Formula.addValueKeyがリファクタリングができそうな作りになっている
* [ ] 10+→演算子に「+」が入っている
* [ ] Formula.AddKeyがValueKeySequence.AddKeyに一本化できそう
* [ ] その他
  * [x] 123をValueKeyにしたものと、"123"をValueKeyにしたものが等価

## 最終的な目標

* [x] 9桁の整数の四則演算を行う
  * [x] ゼロ除算、オーバーフローを検知できるようにする
* [ ] 3++2=→7,11,15...

## 完了したToDoブロック

### 四則演算
* [x] 四則演算1
  * [x] +表示→0
  * [x] 10+表示→10
  * [x] 10+234表示234
  * [x] 10+234=244
* [x] 四則演算2
  * [x] 244-144=100
  * [x] 100/50=2
  * [x] 2*7=14
  * [x] 14/0=例外
  * [x] 9桁×9桁で例外を発生させない
* [x]] 四則演算3
  * [x] 50-+50=100(演算子の訂正ができる)
  * [x] 1+1+1=3
* [x] 数値の入力
  * [x] 空=0
  * [x] 1=1
  * [x] 15=15
    * [x] 9桁制限に従う
    * [x] マイナスは桁数に含めない
  * [x] 10+/-→-10
  * [x] 10+10=5+5=で10が表示される(一度計算に使った数値はロックされる)
    * [x] ValueKeySequence.addKeyの副作用を除去する
    * [x] addKeyで新しくValueKeySequenceを作るLockedSequenceを実装する
* [x] クリア機能
  * [x] 1+2CE20=→21
  * [x] 1+2C20=→20