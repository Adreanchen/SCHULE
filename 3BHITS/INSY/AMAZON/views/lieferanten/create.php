<?php

use yii\helpers\Html;

/** @var yii\web\View $this */
/** @var app\models\Lieferanten $model */

$this->title = Yii::t('app', 'Create Lieferanten');
$this->params['breadcrumbs'][] = ['label' => Yii::t('app', 'Lieferantens'), 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="lieferanten-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
