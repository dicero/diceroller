
const languageCf = {
	'ZH': {
		nav: {
			gpx: '公平性',
			bz: '帮助',
			gd: '更多',
			gpxyz: '公平性验证',
			znhy: '智能合约',
			cz: '充值',
			qk: '取款',
			slt: '水龙头',
			zh: '账户'
		},
		foot: {
			zy: '主页',
			bk: '博客',
			gpx: '公平性',
			faq: 'FAQ',
			tj: '推荐',
			bz: '帮助',
			lxwm: '联系我们',
			Forum: 'Forum',
			ytflt: '以太坊论坛',
			facebook: 'facebook',
			Twitter: 'Twitter',
			Reddit: 'Reddit',
			bccmyf: '博彩沉迷预防'
		},
		register: {
			zc: '注册',
			title: '最受欢迎的和最值得信赖的以太坊博彩网站',
			jr: '加入',
			yyzh: '已经有一个账户了？',
			zzldl: '在这里登录',
			placeholder: '输入你的用户名'
		},
		login: {
			title: '最受欢迎的和最值得信赖的以太坊博彩网站',
			placeholderName: '输入你的用户名',
			placeholderPassword: '输入你的密码',
			dl: '登录',
			wjmm: '忘记密码？',
			hd: '回到建立账户页面'
		},
		play: {
			sdxz: '手动下注',
			zdxz: '自动下注',
			yzse: '押注数额',
			zd: '最大',
			yl: '盈利',
			gc: '滚存',
			fgc: '反滚存',
			pc: '派彩',
			sl: '胜率',
			qd: '确定',
			qx: '取消',
			ts: '投骰'
		},
		betMessage: {
			qb: '全部',
			dq: '当前',
			xzzje: '下注总金额',
			qblr: '全部利润',
			zghsjs: '总共获胜局数',
			qbsdjs: '全部输掉局数',
			xzzs: '下注总数',
			sl: '胜率',
			jl: '机率'
		},
		betLists: {
			yzid: '押注ID',
			yh: '用户',
			sj: '时间',
			yz: '押注',
			pc: '派彩',
			yx: '游戏',
			tz: '投掷',
			yl: '盈利',
			wdyz: '我的押注',
			syyz: '所有押注',
			dedzwj: '大额赌注玩家',
		},
		accountHead: {
			sz: '设置',
			aq: '安全'
		},
		contract: {
			znhy: '智能合约',
			h3: 'WIN MASSIVE AMOUNTS OF ETHER!',
			p1: '1.Register Account And Recharge',
			p2: '2.Payouts are Nearly Instant',
			p3: '3.Play from Anywhere'
		},
		betDetail: {
			yzh: '押注号',
			y: '由',
			z: '在',
			yz: '押注',
			yzje: '押注金额',
			yzpc: '押注派彩',
			yzyl: '押注盈利',
			mb: '目标',
			tz: '投掷',
			yzxx: '验证信息',
			fwqzz: '服务器种子 (HASHED)',
			yhzz: '用户种子 (NONCED)',
			zs: '骰子数字是由HMAC SHA512功能生成的，该功能的关键是服务器种子和一次性随机客户种子使用以下信息: HMAC(serverSeed, clientSeed-nounce)。为了获得由HMAC运行结果生成的骰子数，系统将取前五位并将其作为一个整数。如果这个数字比10^6大，那么就跳过这一个，取接下来5位。把合适结果用10^4模除，获得一个在0-9999之间的数字，再将这个数字除以10^2，生成一个0-99.99之间的数字。想要了解关于可证公平性方面的详细信息，请参考',
			yzym: '验证页面'
		},
		equity: {
			gpx: '公平性',
			zs: 'Diceroller使用了十分简便的投注认证系统。在投注之前服务器种子会被散列和展示出来，用户可以选择任何一个种子。服务器种子在浏览器中显示时会以颜色进行标注，这样一来您就能方便地分辨出看到的种子是否是一样的了。',
			gdxx: '更多信息',
			sjh: '随机化',
			ggyhzz: '更改用户种子',
			dqzzd: '当前种子对',
			yhzz: '用户种子',
			fwqzzs: '服务器种子sha-256散列',
			ypdjxdyz: '由配对进行的押注',
			ywzzpd: '以往种子配对',
			fwqzz: '服务器种子',
			cxyz: '查询押注',
			tg: '您可以通过查询押注来确认以往投掷的公正性。',
			ck: '查看',
			xfwqzz: '新服务器种子(散列)',
			xyhzz: '新用户种子',
			ggzz: '更改种子'
		},
		recharge: {
			dz: '您的个人地址是',
			fz: '复制到剪贴板'
		},
		withdrawal: {
			dz: '以太坊地址',
			je: '金额 (最小 0.004)',
			qk: '取款'
		},
		settings: {
			szxmm: '设置新密码',
			placeholderJmm: '旧密码',
			placeholderXmm: '新密码',
			placeholderQdxmm: '确定新密码',
			sz: '设置',
			gg: '更改'
		},
		verify: {
			rz: '认证',
			h31: 'F公平性',
			p1: 'Diceroller提供顶最优质的认证系统，可以让我们的用户确认每一次掷骰的公正性，并确保过程不受人为操纵。我们的随机数是通过两个种子生成的，一个是服务器种子，另一个是您的用户种子。服务器种子是在您确认自己的用户种子之前生成的，这确保了生成的服务器种子不会偏向我们。它们一起，再加上一个随机一次性数字（种子对下注次数），可以生成在0',
			h32: '种子',
			p2: '通过可证实公平按钮，用户可以更改和验证使用的种子。您可点击页面上方可验证公平按钮旁边的',
			h33: '骰子数',
			p3: 'Diceroller使用多步过程生成一个在0-99.99之间的骰子数。用户种子,服务器种子和一个随机一次性数值会通过 hmac-sha512(server_seed, client_seed-nonce) 结合，生成一个十六位字符串。随机一次性数值是您使用当前种子对的下注次数。该字符串的前五位会被用来生成一个0-1,048,575之间的骰子数。如果这个数字大于999,999，那么系统将跳过这一组字符，重复这一步骤，直到生成的数值小于1,000,000。假如发生没有任何五位满足条件的小概率事件，那么将取99.99作为骰子数。生成的满足条件的数字会除以10^2，生成一个0-99.99之间的数字。',
			h34: '如何验证',
			p4: '您可以使用第三方工具验证数字的公平性，或使用下列Node.js代码重新运行以上过程。运行结果将与您的骰子数一致。'
		},
		advise: {
			fk: '反馈',
			jy: '建议',
			yx: '邮箱',
			yxgs: '邮箱格式不正确',
			qd: '确定',
			qx: '取消'
		},
		message: {
			mmbnwk: '密码不能为空',
			mmszcg: '密码设置成功',
			mmbunxy: '密码不能少于10个字符串',
			lcmmbyz: '两次密码不一致',
			jmmbnwk: '旧密码不能为空',
			xmmbnwk: '新密码不能为空',
			jmmbzq: '旧密码不正确',
			drcg: '登陆成功',
			yhmycz: '用户名已存在',
			yhwdl: '用户未登陆',
			qqcf: '请求重复',
			qqsb: '请求失败',
			zhhmmcw: '用户名或密码错误！',
			txjedyzhye: '提现金额大于账户余额',
			txsqcg: '提现申请成功',
			txsqsb: '提现申请失败',
			tjcg: '提交成功'
		}
	},
	'EN': {
		nav: {
			gpx: 'fairness',
			bz: 'Help',
			gd: 'more',
			gpxyz: 'Fairness Verification',
			znhy: 'smart contract',
			cz: 'recharge',
			qk: 'Withdrawal',
			slt: 'tap',
			zh: 'Account'
		},
		foot: {
			zy: 'home page',
			bk: 'blog',
			gpx: 'fairness',
			faq: 'FAQ',
			tj: 'Recommended',
			bz: 'Help',
			lxwm: 'Contact Us',
			Forum: 'Forum',
			ytflt: 'Ethereum Forum',
			facebook: 'facebook',
			Twitter: 'Twitter',
			Reddit: 'Reddit',
			bccmyf: 'betting addictive prevention'
		},
		register: {
			zc: 'registered',
			title: 'The Most Popular and Trustworthy Ethereum Gaming Website',
			jr: 'join',
			yyzh: 'Already have an account? ',
			zzldl: 'login here',
			placeholder: 'Enter your username'
		},
		login: {
			title: 'The Most Popular and Trustworthy Ethereum Gaming Website',
			placeholderName: 'Enter your username',
			placeholderPassword: 'Enter your password',
			dl: 'login',
			wjmm: 'Forgot your password ? ',
			hd: 'Back to create account page'
		},
		play: {
			sdxz: 'Manual betting',
			zdxz: 'Automatic betting',
			yzse: 'bet amount',
			zd: 'largest',
			yl: 'profit',
			gc: 'Rolling out',
			fgc: 'anti-roll',
			pc: 'Payout',
			sl: 'winning percentage',
			qd: 'OK',
			qx: 'Cancel',
			ts: 'roll dice'
		},
		betMessage: {
			qb: 'all',
			dq: 'current',
			xzzje: 'The total amount of betting',
			qblr: 'full profit',
			zghsjs: 'Total wins',
			qbsdjs: 'lose all the numbers',
			xzzs: 'Total Bet',
			sl: 'winning percentage',
			jl: 'Probability'
		},
		betLists: {
			yzid: 'Bet ID',
			yh: 'user',
			sj: 'time',
			yz: 'Betting',
			pc: 'Payout',
			yx: 'game',
			tz: 'Throw',
			yl: 'profit',
			wdyz: 'My Bet,',
			syyz: 'All bets',
			dedzwj: 'Big Bet Player',
		},
		accountHead: {
			sz: 'Settings',
			aq: 'safe'
		},
		contract: {
			znhy: 'smart contract',
			h3: 'WIN MASSIVE AMOUNTS OF ETHER!',
			p1: '1.Register Account And Recharge',
			p2: '2.Payouts are Nearly Instant',
			p3: '3.Play from Anywhere'
		},
		betDetail: {
			yzh: 'bet number',
			y: 'from',
			z: 'on',
			yz: 'Betting',
			yzje: 'bet amount',
			yzpc: 'Bet betting',
			yzyl: 'Bet profitable',
			mb: 'target',
			tz: 'Throw',
			yzxx: 'authentication information',
			fwqzz: 'server seed(HASHED)',
			yhzz: 'User Seed (NONCED)',
			zs: 'Dice numbers are generated by the HMAC SHA512 feature. The key to this feature is the following information for server seed and one-time random customer seed: HMAC (serverSeed, clientSeed-nounce). In order to get the number of dice generated by the HMAC run result, the system takes the first five digits and takes it as an integer. If this number is larger than 10 ^ 6 then skip this one and take the next 5 digits. Divide the appropriate result by 10 ^ 4 to get a number between 0 and 9999, and divide the number by 10 ^ 2 to produce a number between 0 and 99.99. For more information on the fairness of the filing, please refer to',
			yzym: 'Validation page'
		},
		equity: {
			gpx: 'Fairness',
			zs: 'Diceroller uses a very easy betting certification system. The server seeds will be hashed and displayed before betting, and the user can choose any one seed. Server seeds are color-coded when displayed in the browser, so you can easily tell if the seeds you see are the same. ',
			gdxx: 'More info',
			sjh: 'randomization',
			ggyhzz: "change user's seed",
			dqzzd: 'current seed pair',
			yhzz: 'user seed',
			fwqzzs: 'server seed sha-256 hash',
			ypdjxdyz: 'Betting by pairing',
			ywzzpd: 'past seed pairing',
			fwqzz: 'server seed',
			cxyz: 'Query betting',
			tg: 'You can check the fairness of past throws by querying the bet. ',
			ck: 'View',
			xfwqzz: 'new server seed (hash)',
			xyhzz: 'new user seed',
			ggzz: 'Change the seed'
		},
		recharge: {
			dz: 'Your personal address is',
			fz: 'Copy to clipboard'
		},
		withdrawal: {
			dz: 'Ethereum Address',
			je: 'Amount (minimum 0.004)',
			qk: 'Withdrawal'
		},
		settings: {
			szxmm: 'Set new password',
			placeholderJmm: 'old password',
			placeholderXmm: 'new password',
			placeholderQdxmm: 'Confirm new password',
			sz: 'Settings',
			gg: 'change'
		},
		verify: {
			rz: 'certification',
			h31: 'F fairness',
			p1: 'Diceroller offers the highest quality certification system that allows our users to verify the integrity of each dice and make sure the process is not manipulated. Our random number is generated by two seeds, one is the server seed and the other is your user seed. The server seed is generated before you identify your own user seed, which ensures that the generated server seed does not bias us. Together, together with a random one-time number (the number of seed pairs bet) can be generated at 0 ',
			h32: 'seed',
			p2: "With the Affirmable Fairness button, users can change and verify the seeds used. You can click the 'Fair' button above the page to verify it",
			h33: 'number of dice',
			p3: 'Diceroller uses a multi-step process to generate a number of dice between 0-99.99. The user seed, the server seed, and a random one-time value are combined to form a 16-character string via hmac-sha512 (server_seed, client_seed-nonce). The random one-time number is the number of bets you use for the current seed pair. The first five digits of the string are used to generate a number of dice between 0-1,048,575. If this number is greater than 999,999, the system will skip this set of characters and repeat this step until the resulting value is less than 1,000,000. If there are not any five small probability events that satisfy the condition, then 99.99 will be taken as the number of dice. Generated to meet the conditions of the figures will be divided by 10 ^ 2, generating a number between 0-99.99. ',
			h34: 'How to verify',
			p4: 'You can use third-party tools to verify the fairness of numbers, or run the above procedure again using the following Node.js code. The result of the run will be the same as the number of your dice. '
		},
		advise: {
			fk: 'Feedback',
			jy: 'suggestion',
			yx: 'mailbox',
			yxgs: 'E-mail format is incorrect',
			qd: 'OK',
			qx: 'Cancel'
		},
		message: {
			mmbnwk: 'password can not be empty',
			mmszcg: 'password is set successfully',
			mmbunxy: 'password can not be less than 10 strings',
			lcmmbyz: 'inconsistent password twice',
			jmmbnwk: 'old password can not be empty',
			xmmbnwk: 'New password can not be blank',
			jmmbzq: 'old password is incorrect',
			drcg: 'Login successfully',
			yhmycz: 'username already exists',
			yhwdl: 'User not logged in',
			qqcf: 'request repeat',
			qqsb: 'request failed',
			zhhmmcw: 'username or password is wrong! ',
			txjedyzhye: 'withdrawal amount greater than account balance',
			txsqcg: 'Withdrawal application successful',
			txsqsb: 'withdrawal application failed',
			tjcg: 'Submitted successfully'
		}
	},
	'JP': {
		nav:{
			gpx:'公正さ',
			bz: 'ヘルプ',
			gd: 'もっと',
			gpxyz:'公平性検証',
			znhy:'スマート契約',
			cz: '再充電',
			qk:'引退',
			slt: 'タップ',
			en: 'アカウント'
		},
		foot:{
			zy: 'ホームページ',
			bk: 'blog',
			gpx: '公正さ',
			faq:'FAQ',
			tj:'おすすめ',
			bz: 'ヘルプ',
			lxwm:'お問い合わせ',
			Forum: 'フォーラム',
			ytflt: 'エテリアムフォーラム',
			facebook: 'facebook',
			Twitter: 'Twitter',
			Reddit: 'Reddit',
			bccmyf:'賭け中毒性の予防'
		},
		register:{
			zc: '登録',
			title:'最も人気があり信頼できるエテリアムゲームサイト',
			jr: '参加する',
			yyzh: '既にアカウントを持っていますか？ ',
			zzldl: 'ここにログイン',
			placeholder: 'あなたのユーザ名を入力してください'
		},
		login:{
			title:'最も人気があり信頼できるエテリアムゲームサイト',
			placeholderName: 'あなたのユーザー名を入力してください',
			placeholderPassword: 'パスワードを入力してください',
			dl: 'ログイン',
			wjmm:'パスワードを忘れましたか？ ',
			hd: 'アカウントページの作成に戻る'
		},
		play:{
			sdxz: '手動賭け',
			zdxz:'自動賭け',
			yzse:'賭け金額',
			zd:'最大',
			yl:'利益',
			gc: 'ロールアウト',
			fgc: 'アンチロール',
			pc: 'ペイアウト',
			sl: '獲得率',
			qd:'OK',
			qx: 'キャンセル',
			ts: 'ロールダイス'
		},
		betMessage:{
			qb: 'すべて',
			dq: '現在',
			xzzje: '賭けの総額',
			qblr:'完全利益',
			zghsjs: '合計獲得数',
			qbsdjs:'すべての数字を失う',
			xzzs: 'トータルベット',
			sl: '獲得率',
			jl: '確率'
		},
		betLists:{
			yzid:'ベットID',
			yh: 'ユーザー',
			sj: '時間',
			yz:'ベット',
			pc: 'ペイアウト',
			yx: 'ゲーム',
			tz: 'スロー',
			yl:'利益',
			wdyz:'マイ・ベット',
			syyz: 'すべての賭け',
			dedzwj:'ビッグ・ベット・プレイヤー'
		},
		accountHead:{
			sz: '設定',
			aq: '安全'
		},
		contract:{
			znhy:'スマート契約',
			h3:'イーターの大量の賞金獲得！',
			p1: '1.アカウントと再登録',
			p2:'2.Payoutsはほぼ即時です ',
			p3: '3.どこからでも再生'
		},
		betDetail:{
			yzh:'ベットナンバー',
			y: 'から',
			z: 'オン',
			yz: 'ベット',
			yzje:'賭け金額',
			yzpc:'ベットする',
			yzyl:'利益を上げる',
			mb: 'target',
			tz: 'スロー',
			yzxx: '認証情報',
			fwqzz: "サーバーシード'（ハッシュ）",
			yhzz: 'ユーザーシード（NONCED）',
			zs: 'ダイス番号はHMAC SHA512の機能によって生成されます。この機能の鍵は,サーバーシードとワンタイムランダムな顧客シードに関する以下の情報です:HMAC（serverSeed,clientSeed-nounce）。 HMAC実行結果によって生成されたダイスの数を得るために,システムは最初の5桁を取り,それを整数として取ります。この数字が10 ^ 6より大きい場合,この数字をスキップして次の5桁を取る。適切な結果を10 ^ 4で割り,0と9999の間の数を求め,その数を10 ^ 2で割り,0と99.99の間の数を作ります。提出書類の公平性についての詳細は',
			yzym: '検証ページ'
		},
		equity:{
			gpx: '公平性',
			zs: 'Dicerollerは非常に簡単な賭け証明システムを使用しています。サーバーのシードは,賭けの前にハッシュ表示され,ユーザーは任意のシードを選択することができます。サーバーのシードは,ブラウザに表示されたときに色分けされているため,表示されるシードが同じかどうかを簡単に判断できます。 ',
			gdxx: '詳細情報',
			sjh: 'ランダム化',
			ggyhzz: 'ユーザーの種子を変更する',
			dqzzd: '現在のシードペア',
			yhzz: 'ユーザーシード',
			fwqzzs: 'サーバシードsha-256ハッシュ',
			ypdjxdyz:'ペアリングによるベット',
			ywzzpd: '過去のシードペアリング',
			fwqzz: 'サーバシード',
			cxyz: 'ベットのクエリ',
			tg: '賭けを照会することによって,過去のスローの公正さをチェックすることができます。', 
			ck: '表示',
			xfwqzz: '新しいサーバーシード（ハッシュ）',
			xyhzz: '新しいユーザーシード',
			ggzz: '種を変える'
		},
		recharge:{
			dz:'あなたの個人的な住所は',
			fz: 'クリップボードにコピー'
		},
		withdrawal:{
			dz: 'Ethereum Address',
			je: '金額（最小0.004）',
			qk:'引退'
		},
		settings:{
			szxmm: '新しいパスワードを設定する',
			placeholderJmm: '古いパスワード',
			placeholderXmm: '新しいパスワード',
			placeholderQdxmm: '新しいパスワードを確認する',
			sz: '設定',
			gg: '変更'
		},
		verify:{
			rz: '認証',
			h31:'Fフェアネス',
			p1: "Dicerollerは,ユーザーが各ダイスの完全性を確認し,プロセスが操作されていないことを確認できる最高品質の認証システムを提供します。乱数は2つのシードから生成され,1つはサーバーシードで,もう1つはユーザーシードです。サーバーシードは,独自のユーザーシードを特定する前に生成されます。これにより,生成されたサーバーシードが私たちに偏っていないことが保証されます。一緒に,ランダムなワンタイムナンバー（ベットしたシードペアの数）を0 'で生成することができます。",
			h32: 'シード',
			p2: 'Affirmable Fairness（好意的公正価値）ボタンを使用すると,ユーザーは使用する種子を変更して確認できます。ページの上にある"フェア"ボタンをクリックして確認したり',
			h33:'サイコロの数',
			p3: 'Dicerollerは,マルチステッププロセスを使用して,0〜99.99の間に複数のダイスを生成します。ユーザーシード,サーバーシード,ランダムワンタイム値を組み合わせて,hmac-sha512（server_seed,client_seed-nonce）を介して16文字の文字列を生成します。ランダムワンタイムナンバーは,現在のシードペアに使用するベットの数です。文字列の最初の5桁は,0〜1,048,575の間の数のサイコロを生成するために使用されます。この数値が999,999より大きい場合,システムはこの文字セットをスキップし,結果の値が1,000,000未満になるまでこの手順を繰り返します。条件を満たす5つの小さな確率イベントがない場合,99.99がダイスの数とみなされます。数字の条件を満たすために生成されたものは10 ^ 2で除算され,0〜99.99の数値が生成されます。 ',
			h34:'確認する方法',
			p4: 'サードパーティのツールを使用して数値の公平性を検証するか,次のNode.jsコードを使用して上記の手順を再度実行できます。ランの結果はあなたのサイコロの数と同じになります。 '
		},
		advise:{
			fk: 'フィードバック',
			jy:'提案',
			yx: 'メールボックス',
			yxgs: '電子メール形式が正しくありません',
			qd:'OK',
			qx: 'キャンセル'
		},
		message: {
			mmbnwk:'パスワードは空ではありません',
			mmszcg:'パスワードが正しく設定されました',
			mmbunxy:'パスワードは10文字以下にすることはできません',
			lcmmbyz:'一貫性のないパスワードを2回',
			jmmbnwk:'古いパスワードは空ではありません',
			xmmbnwk:'新しいパスワードは空白にできません',
			jmmbzq:'古いパスワードが間違っています',
			drcg:'ログインに成功しました',
			yhmycz:'username already exists',
			yhwdl:'ユーザーはログインしていません',
			qqcf:'要求の繰り返し',
			qqsb:'要求に失敗しました',
			zhhmmcw:'ユーザー名かパスワードが間違っています！ ',
			txjedyzhye:'口座残高以上の引き出し額',
			txsqcg:'退会申請に成功しました',
			txsqsb:'撤退申請に失敗しました',
			tjcg:'送信が成功しました'
		}
	},
	'RU': {
		nav: {
			gpx: 'справедливость',
			bz: 'Справка',
			gd: 'больше',
			gpxyz: 'Проверка достоверности',
			znhy: 'умный контракт',
			cz: 'перезарядка',
			qk: 'Снятие средств',
			slt: 'tap',
			ru: 'Учетная запись'
		},
		foot: {
			zy: 'домашняя страница',
			bk: 'blog',
			gpx: 'справедливость',
			faq: 'FAQ',
			tj: 'Рекомендуется',
			bz: 'Справка',
			lxwm: 'Свяжитесь с нами',
			Forum: 'Форум',
			ytflt: 'Ethereum Forum',
			facebook: 'facebook',
			Twitter: 'Twitter',
			Reddit: 'Reddit',
			bccmyf: 'борьба с наркотиками'
		},
		register: {
			zc: 'регистрация',
			title: 'Самый популярный и заслуживающий доверия веб-сайт игры Эфириум ',
			jr: 'join',
			yyzh: 'У вас уже есть аккаунт? ',
			zzldl: 'login here',
			placeholder: 'Введите свое имя пользователя'
		},
		login: {
			title: 'Самый популярный и заслуживающий доверия веб-сайт игры Эфириум ',
			placeholderName: 'Введите свое имя пользователя',
			placeholderPassword: 'Введите свой пароль',
			dl: 'войти',
			wjmm: 'Забыли пароль? ',
			hd: 'Вернуться к созданию страницы учетной записи'
		},
		play: {
			sdxz: 'Ручная ставка',
			zdxz: 'Автоматические ставки',
			yzse: 'сумма ставки',
			zd: 'самый большой',
			yl: 'прибыль',
			gc: 'Роллинг',
			fgc: 'Антирезиновый депозит',
			pc: 'Выплата',
			sl: 'процент выигрыша',
			qd: 'определить',
			qx: 'Отмена',
			ts: 'Броски'
		},
		betMessage: {
			qb: 'полный',
			dq: 'текущий',
			xzzje: 'Общая сумма ставок',
			qblr: 'полная прибыль',
			zghsjs: 'Всего побед',
			qbsdjs: 'потерять все числа',
			xzzs: 'Общая ставка',
			sl: 'процент выигрыша',
			jl: 'Вероятность'
		},
		betLists: {
			yzid: 'Идентификатор ставки',
			yh: 'пользователь',
			sj: 'время',
			yz: 'Ставки',
			pc: 'Выплата',
			yx: 'игра',
			tz: 'Бросок',
			yl: 'прибыль',
			wdyz: 'Моя ставка',
			syyz: 'Все ставки',
			dedzwj: 'Игроки с большими ставками'
		},
		accountHead: {
			sz: 'Настройки',
			aq: "безопасный"
		},
		contract: {
			znhy: 'умный контракт',
			h3: 'ВЫИГРАЙТЕ МАССИВНЫЕ СУММЫ ЭФИРА!',
			p1: '1.Регистрация учетной записи и перезарядка',
			p2: '2.Платежи почти мгновенно',
			p3: '3.Play from Anywhere'
		},
		betDetail: {
			yzh: 'количество ставок',
			y: 'К',
			z: 'в',
			yz: 'Ставки',
			yzje: 'сумма ставки',
			yzpc: 'Ставки ставок',
			yzyl: 'Ставка выгодна',
			mb: 'target',
			tz: 'Бросок',
			yzxx: 'информация аутентификации',
			fwqzz: 'семя сервера (HASHED)',
			yhzz: 'Пользовательское семя (NONCED)',
			zs: 'Номера Dice генерируются функцией HMAC SHA512. Ключом к этой функции является следующая информация для семян сервера и одноразового случайного посева клиента: HMAC (serverSeed, clientSeed-nounce). Чтобы получить количество костей, сгенерированных результатом выполнения HMAC, система берет первые пять цифр и принимает их как целое число. Если это число больше 10 ^ 6, пропустите это и сделайте следующие 5 цифр. Разделите соответствующий результат на 10 ^ 4, чтобы получить число от 0 до 9999, и разделите число на 10 ^ 2, чтобы получить число от 0 до 99.99. Для получения дополнительной информации о справедливости подачи, пожалуйста, обратитесь к',
			yzym: 'Страница проверки'
		},
		equity: {
			gpx: 'справедливость',
			zs: 'Diceroller использует очень легкую систему сертификации ставок. Перед тем, как делать ставки, семена сервера будут хэшироваться и отображаться, и пользователь может выбрать любое семя. Семена сервера кодируются цветом при отображении в браузере, поэтому вы можете легко определить, совпадают ли семена. ',
			gdxx: 'Дополнительная информация',
			sjh: 'рандомизация',
			ggyhzz: 'изменить семя пользователя',
			dqzzd: 'текущая пара семян',
			yhzz: 'пользовательское семя',
			fwqzzs: 'серверный шай-256 хэш',
			ypdjxdyz: 'Ставки по спариванию',
			ywzzpd: 'спаривание прошлых семян',
			fwqzz: 'семя сервера',
			cxyz: 'Запрос ставок',
			tg: 'Вы можете проверить справедливость прошлых бросков, запросив ставку. ',
			ck: 'Просмотр',
			xfwqzz: 'новое семя сервера (hash)',
			xyhzz: 'новое семя пользователя',
			ggzz: 'Изменение семян'
		},
		recharge: {
			dz: 'Ваш личный адрес',
			fz: 'Копировать в буфер обмена'
		},
		withdrawal: {
			dz: 'Ethereum Address',
			je: 'Сумма (минимум 0,004)',
			qk: 'Изъятие'
		},
		settings: {
			szxmm: 'Установить новый пароль',
			placeholderJmm: 'старый пароль',
			placeholderXmm: 'новый пароль',
			placeholderQdxmm: 'Подтвердить новый пароль',
			sz: 'Настройки',
			gg: 'изменение'
		},
		verify: {
			rz: 'сертификация',
			h31: 'F справедливость',
			p1: 'Diceroller предлагает систему сертификации самого высокого качества, которая позволяет нашим пользователям проверять целостность каждой кости и следить за тем, чтобы процесс не обрабатывался. Наше случайное число генерируется двумя семенами: одно - это семя сервера, а другое - ваше семя пользователя. Семя сервера генерируется до того, как вы определите свое собственное семя пользователя, что гарантирует, что сгенерированное семя сервера не смещает нас. Вместе вместе со случайным одноразовым номером (количество ставок пар семян) можно сгенерировать при 0 ',
			h32: 'семя',
			p2: "С кнопкой' Подтверждающая справедливость 'пользователи могут изменять и проверять используемые семена. Вы можете нажать кнопку 'Ярмарка' над страницей, чтобы проверить ее",
			h33: 'количество кубиков',
			p3: 'Diceroller использует многоступенчатый процесс для создания нескольких кубиков между 0-99.99. Сегмент пользователя, семя сервера и случайное одноразовое значение объединяются для формирования 16-символьной строки через hmac-sha512 (server_seed, client_seed-nonce). Случайное одноразовое число - это количество ставок, которые вы используете для текущей пары семян. Первые пять цифр строки используются для генерации ряда кубиков между 0-1 048 575. Если это число больше 999,999, система пропустит этот набор символов и повторит этот шаг до тех пор, пока результирующее значение не станет меньше 1 000 000. Если не существует пяти малых вероятностных событий, удовлетворяющих условию, то 99.99 будет приниматься за количество кубиков. Сгенерированные в соответствии с условиями фигуры будут разделены на 10 ^ 2, генерируя число от 0 до 99,99. ',
			h34: 'Как проверить',
			p4: 'Вы можете использовать сторонние инструменты для проверки справедливости чисел или повторить описанную выше процедуру, используя следующий код Node.js. Результат прогона будет таким же, как и количество ваших кубиков. '
		},
		advise: {
			fk: 'Обратная связь',
			jy: 'предложение',
			yx: 'почтовый ящик',
			yxgs: 'Неверный формат электронной почты',
			qd: 'ОК',
			qx: 'Отменить'
		},
		message: {
			mmbnwk: 'пароль не может быть пустым',
			mmszcg: 'пароль успешно установлен',
			mmbunxy: 'пароль не может быть меньше 10 строк',
			lcmmbyz: 'непоследовательный пароль дважды',
			jmmbnwk: 'старый пароль не может быть пустым',
			xmmbnwk: 'Новый пароль не может быть пустым',
			jmmbzq: 'старый пароль неверен',
			drcg: 'Войти успешно',
			yhmycz: 'имя пользователя уже существует',
			yhwdl: 'Пользователь не вошел в систему',
			qqcf: 'request repeat',
			qqsb: 'запрос не выполнен',
			zhhmmcw: 'имя пользователя или пароль неверны! ',
			txjedyzhye: 'сумма вывода превышает остаток на счете',
			txsqcg: 'Успешно завершено применение приложения',
			txsqsb: 'попытка отмены отказа',
			tjcg: 'Отправлено успешно'
		}
	},
}

export { languageCf }