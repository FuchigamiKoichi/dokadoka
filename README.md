# java最終課題　dokadokaゲーム

## ・概要
    java最終課題として、バトル系人生ゲームを作成しました。
    約１ヶ月半を使って、バトル班とすごろく班に分けて開発を行いました。
    javaswingやjavaawtを使ってGUIを実装しました。

## ・ゲーム内容
    プレイヤーの操作の基本は人生ゲームと同様です。
    自分の番になれば、すごろく（このゲーム内ではダイス）を振り出た目に応じてマップ上のマスを移動することができます。
    最終的な目標も人生ゲームと同様に最終的に所持している金額が多くなるようにすることです。
    しかし、マスには人生ゲームのようなライフイベントを模したイベントが設定されているのではなく、
    NPC（ノンプレイヤーキャラクター）とのバトルがイベントとして設定されています。
    特別に、他のプレイヤーと同じマスになった場合にはそのプレイヤーとのバトルをすることも可能になります。
    バトルについて、
    バトルは攻撃側と防御側に分かれそれぞれが自身の行動を決め防御側が二者が選択したものに応じたダメージを負います。
    これをどちらかのHPが０になるまで続けます。
    勝った側は所持金が増えます。
    ゲームは２０ターン制で、全てのプレイヤーがダイスを振り移動を全て終えることで１ターンが終わります。

## ・ディレクトリ
    ・dokapon_battle
    バトルに関する内部処理を記述したソースファイルが保存されています。
    
    ・dokapon_sugoroku
    人生ゲーム的処理を行うためのソースファイルが保存されています。
    この処理はプレイヤーの移動などの画面表示的な処理を多く含むため、以下のShowディレクトリに処理の多くが吸収されています。
        
    ・Show
    上記二つのソースファイルで定義された処理を使って、GUIによってプレイヤーが実際に操作しプレイする画面を作成する処理をするソースファイルが保存されています。

    ・IMG
    このゲームに表示される画像が保存されています。

    WORLD
    このゲームにおけるマスの情報がCSVファイルとして保存されています。

## ・操作方法
    プレイヤーの操作の基本は人生ゲームと同様です。
    自分の番になれば、すごろく（このゲーム内ではダイス）を振り出した目に応じてマップ上のマスを移動することができます。
    最終的な目標も人生ゲームと同様に最終的に所持している金額が多くなるようにすることです。
    しかし、マスには人生ゲームのようなライフイベントを模したイベントが設定されているのではなく、
    NPC（ノンプレイヤーキャラクター）とのバトルがイベントとして設定されています。
    特別に、他のプレイヤーと同じマスになった場合にはそのプレイヤーとのバトルをすることも可能になります。
    バトルについて、
    バトルは攻撃側と防御側に分かれそれぞれが自身の行動を決め、二者が選択したコマンドに応じたダメージを負います。
    これをどちらかのHPが０になるまで続けます。
    勝った側は所持金が増えます。
    ゲームは２０ターン制で、全てのプレイヤーがダイスを振り移動を全て終えることで１ターンが終わります。